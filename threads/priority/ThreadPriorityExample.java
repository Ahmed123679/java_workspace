package threads.priority;

public class ThreadPriorityExample {
    public static void main(String[] args) {
        // getting thread info
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        // set priority of main thread priority ranges [1 -> 10]
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());
        
    }
}
