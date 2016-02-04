package week10.ReadWriteThreadsArray;

import java.util.ArrayList;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        long size = 1000_000;
        int segments = 10;
        ArrayList<Producer> readers = new ArrayList<>();
        ArrayList<Producer> writers = new ArrayList<>();
        DataBace data = new DataBace(size,segments);
        long start = 0;
        long end = 0;


        for (int i = 0; i <segments ; i++) {
            end = end + data.getSegmentBig();
            readers.add(new Producer(data,start,end,false));
            writers.add(new Producer(data,start,end,true));
            start = end;
        }
        long time = System.currentTimeMillis();

        for (int i = 0; i < segments; i++) {
            writers.get(i).start();
            readers.get(i).start();
            writers.get(i).join();
            readers.get(i).join();
        }

        System.out.println("Test end in " + (System.currentTimeMillis() - time) + "seconds");



    }
}
