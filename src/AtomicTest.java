import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private volatile static int counter = 0;

    private volatile static AtomicInteger ai= new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i< 1000; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j< 100; j++) {
                    ai.incrementAndGet();
//                    synchronized (AtomicTest.class) {
//                        counter++;
//                    }
                }
            });
            threadList.add(t);
        }

        for (Thread t: threadList) {
            t.start();
        }

        for (Thread t: threadList) {
            t.join();
        }

        System.out.println(ai);
    }
}
