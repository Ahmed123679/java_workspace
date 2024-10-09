package threads.thread_pool;

import java.security.MessageDigest;
import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<Message> exchanger = new Exchanger<>();
        Message senderMessage = new Message("Sender", "Sender is writing");
        Message postmanMessage = new Message("postman", "postman is delivering");
        Thread postmanThread = new Thread(new Postman(postmanMessage, exchanger));
        Thread senderThread = new Thread(new Sender(senderMessage, exchanger));
        postmanThread.start();
        senderThread.start();

    }
}

class Sender implements Runnable {
    private Message message;
    private Exchanger<Message> exchanger;
    
    public Sender(Message message, Exchanger<Message> exchanger) {
        this.message = message;
        this.exchanger = exchanger;
    }

    @Override
    public String toString() {
        return "Sender [message=" + message + ", exchanger=" + exchanger + "]";
    }

    @Override
    public void run() {
        System.out.println("Sender: Waiting to give new message to postman");
        try{
            Thread.sleep(5000);
          Message receivedMessage = exchanger.exchange(message);
          System.out.println("Sender: Received from postman: "+ receivedMessage);
        }catch(InterruptedException e) {

        }
    }
}


class Postman implements Runnable {
    private Message message;
    private Exchanger<Message> exchanger;
    
    public Postman(Message message, Exchanger exchanger) {
        this.message = message;
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        System.out.println("Postman: Delivering mesage " + message);
        try {
           Message receivedMessage =  exchanger.exchange(this.message);
           System.out.println("Postman: received :" + receivedMessage);
        } catch (InterruptedException e) {
           
        }
        System.out.println("Postman: Wait for me next Week for another message");
        
    }
    

}

class Message {
    String title;
    String content;
    public Message(String title, String content) {
        this.title = title;
        this.content = content;
    }
    @Override
    public String toString() {
        return "Message [title=" + title + ", content=" + content + "]";
    }
    
    
}
