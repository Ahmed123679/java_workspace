package threads.producer_consumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/*
    Thread:
 * while(true)
 * {
 *  print("Hello world");
 * }
 * 
 * 
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Worker worker = new Worker(5, 0);
        Thread producer = new Thread(()->{
            try {
                worker.produce();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(()->{
            try {
                worker.consume();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
    }
}

class Worker {
    Scanner scanner = new Scanner(System.in);
    private Object lock = new Object();
    private List<String> buffer;
    private Integer maxSize;
    private Integer minSize;
    public Worker(Integer maxSize,Integer minSize)
    {
        this.maxSize = maxSize;
        this.minSize = minSize;
        this.buffer = new LinkedList<>();
    }

    public void produce() throws InterruptedException {
        synchronized(lock)
        {
            while(true)
            {
                if(buffer.size() == maxSize)
                {
                    System.out.println("Waiting to empty the buffer");
                    lock.wait();

                }else {
                    String message =  scanner.nextLine();
                    buffer.add(message);
                    lock.notify();
                    
                }
            }        

        }
    }
    public void consume() throws InterruptedException {
        synchronized(lock)
        {
            while (true) {
                    if(buffer.size() == minSize)
                    {
                        System.out.println("No messages to read");
                        lock.wait();
                    }else {
                        System.out.println("message: " + this.buffer.remove(0));
                        lock.notify();
                    }
            }
        }
    }



}