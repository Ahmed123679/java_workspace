package threads.thread_pool;


import java.util.concurrent.*;
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3) ; 
        new Thread(new Race("BMW",latch)).start();
        new Thread(new Race("Audi",latch)).start();
        new Thread(new Race("Marcedez",latch)).start();
        latch.await(); // wait unti latch reach zero
        System.out.println("all cars "+ "fininshed");
    }
}

class Race implements Runnable {
    private String carname;
    private CountDownLatch latch;
    public Race(String carname,CountDownLatch latch)
    {
        this.carname = carname;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(carname + "is running now!");
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        System.out.println("Car "+ carname + "has reached");
        latch.countDown();

    }
}
