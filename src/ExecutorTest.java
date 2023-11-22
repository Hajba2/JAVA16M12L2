import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        //second();
        ArrayList<Human> objects = new ArrayList<>();
        HashMap<Long, Human> humanHashMap = new HashMap<>();
        returnMultipleVal(objects, humanHashMap, new File(""));

        System.out.println(objects);
        System.out.println(humanHashMap);
    }

    public static void third() throws InterruptedException {
//        List<Thread> threads = new ArrayList<>();
//
//        List<Runnable> tasks = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            tasks.add(new PrintRunnable(i));
//        }
//
//        for (int i = 0; i < tasks.size(); i++) {
//            for (int j = 0; j < threads.size(); j++) {
//                if (threads.size() < 2) {
//                    Thread thread = new Thread(tasks.get(i));
//                    threads.add(thread);
//                }
//            }
//        }
//
//        while (true) {
//            Thread.sleep(200);
//
//            if (futures.stream().allMatch(f -> f.isDone())) {
//                futures.stream().map(f -> {
//                    Long aLong = null;
//                    try {
//                        aLong = f.get();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    } catch (ExecutionException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println(aLong);
//                    return aLong;
//                }).collect(Collectors.toList());
//                break;
//            }
//        }
    }

    public static void second() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Long> future = executorService.submit(new SumCallable(i, i * 2));
            futures.add(future);
        }

        while (true) {
            Thread.sleep(200);

            if (futures.stream().allMatch(f -> f.isDone())) {
                futures.stream().map(f -> {
                    Long aLong = null;
                    try {
                        aLong = f.get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(aLong);
                        return aLong;
                }).collect(Collectors.toList());
                break;
            }
        }

    }

    public static void first() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new PrintRunnable(4));
        es.execute(new PrintRunnable(4));
        es.execute(new PrintRunnable(4));
    }

    public static void returnMultipleVal(List<Human> hList, Map<Long, Human> hMap, File f) {
        //read data from file
        //fill in list
        //fill in map
        hList.add(new Human());
        hList.add(new Human());
        hList.add(new Human());
        hMap.put(1l, new Human());
        hMap.put(2l, new Human());
    }

}
