import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentCollections {

    private List<String> noCuncurentList = new ArrayList<>();
    private CopyOnWriteArrayList<String> cuncurentList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        ConcurrentHashMap chm = new ConcurrentHashMap();
        CopyOnWriteArraySet cws = new CopyOnWriteArraySet();

        ConcurrentCollections concurrentCollections = new ConcurrentCollections();
        concurrentCollections.noCuncurentAdd("Asd");
        concurrentCollections.cuncurentAdd("asd");
    }

    public void cuncurentAdd(String s) {
        cuncurentList.add(s);
    }

    public void noCuncurentAdd(String s) {
        synchronized (noCuncurentList) {
            noCuncurentList.add(s);
        }
    }


}
