package threads.thread_pool;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CahchedPoolDemo {
    public static void main(String[] args) throws FileNotFoundException {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0;i<10;i++)
        {
            service.execute(new Task(i));
        }
        service.shutdown();
        System.out.println("End of excution");
    }
}


