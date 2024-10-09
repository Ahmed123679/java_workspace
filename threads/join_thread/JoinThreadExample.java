package threads.join_thread;

/*
 * join method in threads allows one thread to make main thread wait for compeletion.
 * 
 */

public class JoinThreadExample {
    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getPriority());
            for(int i = 0;i<4;i++)
            {
                // getting thread info
                System.out.println("thread one: " + i);
            }
        });
        Thread two = new Thread(()->{
            // getting thread info
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
            for(int i = 0;i<20;i++)
            {
                System.out.println("thread two: " + i);
            }
        });
        one.start();
        two.start();
        one.join();
        // getting thread info
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println("Done excution");
    }

}

