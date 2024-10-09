package threads.main_daemon;

public class DaemonThreadsExmaple {
    public static void main(String[] args) {
        // creating main and daemon threads
        Thread mainThread = new Thread(new MainThread());
        Thread daemonThread = new Thread(new DaemonThread());
        
        daemonThread.setDaemon(true);
        mainThread.start();
        daemonThread.start();

    }
}

class MainThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        }catch(Exception ex)
        {

        }finally{
            System.out.println("main thread is ended");
        }
    }
}

class DaemonThread implements Runnable {
    @Override
    public void run() {
        try{
            do {
                System.out.println("Daemon thread is running!");
                Thread.sleep(1000);
            }while(true);
            
        }catch(InterruptedException ex)
        {

        }

    }
}
