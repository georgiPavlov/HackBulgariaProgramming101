package week10.CountOddNumbers;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by georgipavlov on 05.02.16.
 */
public class Count {

    public static void main(String[] args) {
        int threadCountForNumbers = 5;
        DB_Numbers.setThreadCount(5);
        DB_Numbers.setBarrier(new CyclicBarrier(threadCountForNumbers,new ConsumerForNumbers()));
        ExecutorService executor = Executors.newFixedThreadPool(threadCountForNumbers);
        for (int i = 0; i <threadCountForNumbers ; i++) {
            executor.execute(new ProduserForNumbers());
        }


    }
}
