package threads.thread_pool;
import java.util.concurrent.*;;

public class CallableExampleDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i = 0;i<10;i++)
        {
           Future<Integer> result =  service.submit(new CallableTask());
           System.out.println(""+i+" is submitted ");
        }
    }


}

class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Hello from " + Thread.currentThread().getName());
        Thread.sleep(1000);
         return 1;   

    }
}
