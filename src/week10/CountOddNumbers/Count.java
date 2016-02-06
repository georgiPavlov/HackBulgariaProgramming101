package week10.CountOddNumbers;

import sun.awt.windows.ThemeReader;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by georgipavlov on 05.02.16.
 */
public class Count {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int threadCountForNumbers = 10;
        DB_Numbers.setThreadCount(threadCountForNumbers);
       // DB_Numbers.setTreasuries();
        DB_Numbers.setBarrier(new CyclicBarrier(threadCountForNumbers,new ConsumerForNumbers(time)));
        ExecutorService executor = Executors.newFixedThreadPool(threadCountForNumbers);
        for (int i = 0; i <threadCountForNumbers ; i++) {
            executor.execute(new ProduserForNumbers(i));
        }



    }
}
