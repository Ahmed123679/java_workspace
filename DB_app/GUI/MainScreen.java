package DB_app.GUI;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
public class MainScreen extends JFrame{
    // gui components members
    private JPanel panel;
    private JTable table;
    private JTextArea editorArea;
    private MenuBar menuBar;
    private Menu file;
    private Menu edit;
    private MenuItem run;
    private Statement statement;
    public MainScreen()
    {
        try {
            // connect to database
            String url = "jdbc:mysql://localhost:3306";
            Connection connection = DriverManager.getConnection(url, "root", "root");
             this.statement = connection.createStatement();
             statement.execute("use test");
            buildScreen();
            }catch(SQLException exception)
            {
                System.out.println(exception);   
            }

    }
    void onRun(ActionEvent e)
    {
        String query = this.editorArea.getText().trim();
        try{

            ResultSet resultSet = statement.executeQuery(query);
            JDialog dialog = new JDialog();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<String> columnNames = new ArrayList<>();
            for(int i = 1;i<=columnCount;i++)
            {
                columnNames.add(metaData.getColumnName(i));
            }
            ArrayList<ArrayList<String>> data = new ArrayList<>();
            data.add(columnNames);
            while(resultSet.next())
            {
                ArrayList<String> row = new ArrayList<>();
                
                for(int i = 1;i<=columnCount;i++)
                {
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
            Object[][] newData = new Object[data.size()][];
            for(int i = 0;i<data.size();i++)
            {
                newData[i] = data.get(i).toArray();
            }

            JTable tableData = new JTable(newData,columnNames.toArray());
           
            dialog.setSize(300,300);
            dialog.add(tableData);
            dialog.setVisible(true);
            
        }catch(SQLException ex)
        {
            System.out.println(ex);
        }
    }
    void buildScreen()
    {
        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());
        // creating menu bar
        this.menuBar = new MenuBar();
        // creating menus 
        this.file = new Menu("File");
        this.edit = new Menu("Edit");
        // adding menus
        this.menuBar.add(this.file);
        this.run = new MenuItem("run");
        this.run.addActionListener(this::onRun);
        this.file.add(run);
        this.menuBar.add(this.edit);
        // creating textarea 
        this.editorArea = new JTextArea(100,20);
        this.editorArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(editorArea);
        
        panel.add(editorArea,BorderLayout.CENTER);
        
        add(panel);
        setMenuBar(this.menuBar);
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
