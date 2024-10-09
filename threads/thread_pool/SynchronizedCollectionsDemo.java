package threads.thread_pool;
import java.util.*;;
public class SynchronizedCollectionsDemo {
    // creating a synchronized collection
    static List<Integer> integers = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args) throws InterruptedException {
       Thread one = new Thread(()->{
        for(int i = 0;i<1000;i++)
        {
            integers.add(i);
        }
       });
       Thread two = new Thread(()->{
        for(int i = 0;i<1000;i++)
        {
            
            integers.add(i);
        }
       });
       one.start();
       two.start();
       one.join();
       two.join();
       System.out.println(integers.size());
    }


}
