package threads.thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SschduledThreadDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        for(int i = 0;i<20;i++)
        {
            service.scheduleAtFixedRate(new Task(i+""), 10,5, TimeUnit.MILLISECONDS);
    
        }
        
        // service.shutdown();        
    }
    

}

