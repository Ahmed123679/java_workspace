package threads.thread_pool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadedServiceDemo {
   
    public static void main(String[] args) {
        
        ExecutorService service =  Executors.newSingleThreadExecutor();
        List<String> taskNames = new ArrayList<>();
        taskNames.addAll(Arrays.asList("Ahmed","ibrahim","Ali"));
        for(int i = 0;i<taskNames.size();i++)
        {
            service.execute(new Task(taskNames.get(i)));
        }
    while(!service.isTerminated())
        {
            System.out.println("still running");
        }
        
        service.shutdown();

    }

}

class Task implements Runnable {
    private String name;
    public Task(String name)
    {
        this.name = name;
    }
    @Override
    public void run() {  
        System.out.println("Task " + this.name + " is running by "+ Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}