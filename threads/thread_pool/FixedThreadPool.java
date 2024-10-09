// package threads.thread_pool;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.PrintWriter;
// import java.sql.Time;
// import java.time.LocalDateTime;
// import java.time.LocalTime;
// import java.util.Timer;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;

// public class FixedThreadPool {
//     public static void main(String[] args) throws FileNotFoundException {
//         ExecutorService service = Executors.newFixedThreadPool(2);
//         for(int i = 0;i<10;i++)
//         {
//             service.execute(new Task(i));
//         }
//         System.out.println("service is done");
//         service.shutdown();
//     }
// }

// class Task implements Runnable {
//     private PrintWriter fileOutput;
//     // private File file;
//     private int id;
//     public Task(int id) throws FileNotFoundException
//     {
//         this.id = id;
//        this.fileOutput = new PrintWriter(new File(""+id+".txt")); 
//     }
//     @Override
//     public void run() {

//         this.fileOutput.println("task-id: "+ id + " "+ LocalTime.now());
//         this.fileOutput.close();
//         // System.out.println("Task "+ id + " is running by " + Thread.currentThread().getName());
//     }
// }