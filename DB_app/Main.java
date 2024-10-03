package DB_app;

import java.sql.Statement;

import DB_app.GUI.MainScreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        new MainScreen();
    //    try {

    //        String url = "jdbc:mysql://localhost:3306/test";
    //        Connection connection = DriverManager.getConnection(url, "root", "root");
    //        Statement statement =  connection.createStatement();
    //        statement.executeUpdate("Insert Into student Values(2,\"Mido\",\"2001-02-09\")");
    //        ResultSet result = statement.executeQuery("Select Count(*) from student");
    //        System.out.println(result.getMetaData());
    //        while(result.next())
    //        {
    //             System.out.println(result.getInt(1));
    //        }
    //    }catch(SQLException exception) {
    //         System.out.println("Can not conenect to mysql"+exception);
    //    }

    }
    
}