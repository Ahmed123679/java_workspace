package threads.thread_creation;

public class Main {
    public static void main(String[] args) {
        // creation of threads using runnable objects
        Thread one = new Thread(new ThreadOne());
        Thread two = new Thread(new ThreadTwo());
        one.start();
        two.start();
        // creating of threads using Thread class
        Thread three = new ThreadThree();
        three.start();
    }
    
}
final class ThreadOne implements Runnable {
    @Override
    public void run() {
        for(int i = 0;i<20;i++)
        {
            System.out.println("Hello from thread1: "+i);
        }
    }
}
final class ThreadTwo implements Runnable {
    @Override
    public void run() {
        for(int i = 0;i<20;i++)
        {
            System.out.println("Hello from thread2: "+i);
        }
    }
}
final class ThreadThree extends Thread {
        @Override
        public void run() {
            for(int i = 0;i<20;i++)
            {
                System.out.println("Hello from thread three: " + i);
            }
        }
}

