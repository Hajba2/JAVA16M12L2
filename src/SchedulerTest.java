import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.schedule(
                () -> System.out.println("text"),
                2,
                TimeUnit.SECONDS
        );

        scheduler.scheduleAtFixedRate(
                () -> System.out.println("text"),
                0,
                2,
                TimeUnit.SECONDS
        );
        //scheduleWithFixedDelay відлік часу для нової задаяі починається тільки після
        // того як попредня задача завершила виконання

        //scheduleAtFixedRate відлік часу починається як тільки попередня задача почала виконання
        scheduler.scheduleWithFixedDelay(
                () -> System.out.println("text"),
                0,
                2,
                TimeUnit.SECONDS
        );
    }

}
