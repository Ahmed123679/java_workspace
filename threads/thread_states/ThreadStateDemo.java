package threads.thread_states;

import java.io.IOException;

public class ThreadStateDemo {
    private static Thread t;
    public static void main(String[] args) throws InterruptedException, IOException {
        // show thread states
        t = new Thread(new ThreadExample());
        // new state
        System.out.println("user thread state now: " + t.getState());
        
        t.setName("User defined thread");
        
        t.start();
        System.out.println("Main thread");
        System.in.read();
        
        
        System.out.println("User defined thread is" + t.getState());
        System.out.println("user thread state now: " + t.getState());
        System.in.read();
        System.out.println("End of main execution");
        // two threads  => main -------
            //          => user defined thread --------


    }
}
class ThreadExample implements Runnable {
    synchronized void  fun()
    {
        
    }
    @Override
    public void run() {
        
        while(true) {      
        System.out.println(Thread.currentThread().getName()+" is "+ Thread.currentThread().getState());
        
        System.out.println(Thread.currentThread().getPriority());
        
        try {
        
            System.out.println("Enter value");
        
            System.in.read();
        
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        // try {
        //     Thread.sleep(40000);
        // } catch (InterruptedException e) {
            
        //     e.printStackTrace();
        // }
        }

    }
}
