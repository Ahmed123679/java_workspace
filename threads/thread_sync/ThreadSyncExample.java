package threads.thread_sync;

public class ThreadSyncExample {
    private static int counter = 0;
    private static Thread one;
    private static Thread two;
    public static void main(String[] args) throws InterruptedException {
          // creating two threads
          one = new Thread(() -> {
            for(int i = 0;i<10000;i++)
            {
                Increment();
            }}
            );
    
        two = new Thread(() -> {
            for(int i = 0;i<10000;i++)
            {
               Increment();
            }});
        // addind two threads
        one.setName("thread one");
        two.setName("thread two");
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println("Counter = " + counter);
    }
    
   public  static void Increment()
   {
        for(int i = 0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName());
            System.out.println("one state - >" + one.getState());
            System.out.println("Two state ->" + two.getState());
        }
        counter++;
        System.out.println("Counter Incremented -> " + counter);
   }    

}


