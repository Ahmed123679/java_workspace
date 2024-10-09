package threads.thread_pool;
import java.util.concurrent.*;
public class BlockingQueueDemo {
    static BlockingQueue<RunnableTask> tasks = new ArrayBlockingQueue<>(10);
    static ConcurrentMap<String,String> map = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        // singleThreaded pool
        for(int i = 0;i<10;i++)
        tasks.add(new RunnableTask());

        Thread singleThread = new Thread(()-> fecthExecute());
        singleThread.start();
    }
    static void addTask() 
    {

    }
    static void fecthExecute()
    {
        while(true)
        {
           RunnableTask task = tasks.poll();
            if(task == null)
            {
                 System.out.println("Queue is empty");
                 return;
            }else {
             task.run();
            }
        }
    }
}
class RunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is running");
    }
}