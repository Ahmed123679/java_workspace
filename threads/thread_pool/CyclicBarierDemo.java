package threads.thread_pool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarierDemo {
    public static final CyclicBarrier barrier = new CyclicBarrier(3,()->{System.out.println("This Stage has ended");});
      
    
    
    public static void main(String[] args) {
        
        Thread one = new Thread(new Stage("Running"));
        Thread two = new Thread(new Stage("shooting"));
        Thread three = new Thread(new Stage("Riding"));
        one.start();
        two.start();
        three.start();
    }
}

class Stage implements Runnable {
    String stageName;
    public Stage(String name)
    {
        this.stageName = name;
    }
    @Override
    public void run() {
       for(int level = 1;level < 10;level++)
       {
            System.out.println("Stating level "+ level);
            try {
                Thread.sleep(500);
                CyclicBarierDemo.barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
            
                e.printStackTrace();
            }       
       }
    }
}
