package threads.send_receive;

import java.util.Scanner;

public class SendReceiveExmaple {
   static boolean isSent = false;
    // private static final Object = new Object();
    private static final Object Lock = new Object();
    private static String packet = "empty packet";
    public static void main(String[] args) throws InterruptedException {
        Thread sender = new Thread(()->{
            while(true) {
                 send();  
            }
        });
        Thread receiver = new Thread(()->{
            while(true) {
                try {
                    receive();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }   
           }
        });
        sender.start();
        receiver.start();
        System.out.println("END");
        
    }

    public static void send()  
    {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        synchronized(Lock)
        {
            System.out.println("after getting the lock");
            packet = message;
            isSent = true;
            Lock.notifyAll();
            try {
                Lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("message is delieverd");
        }
        
    }
    public static void receive() throws InterruptedException
    {
        synchronized(Lock)
        {
            if(isSent == false)
            {
                Lock.wait();
            }else {

                System.out.println(packet);
                Lock.notifyAll();
                System.out.println("message is received");
                isSent = false;
            }
        }
    }
}
