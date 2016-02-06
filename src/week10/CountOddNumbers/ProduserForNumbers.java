package week10.CountOddNumbers;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by georgipavlov on 05.02.16.
 */
public class ProduserForNumbers extends DB_Numbers implements Runnable{
     private long n = 2_000_000_000/threadCount;
     private Random random = new Random();
     private int treasuryNumber;


    public ProduserForNumbers(int treasuryNumber) {
        this.treasuryNumber = treasuryNumber;
    }

    @Override
    public void run() {
        int number;
        System.out.println("Start producing");
        for (int i = 0; i < n ; i++) {
            number = random.nextInt(20000000);
            if( (number & 1) != 0 ){
                count.getAndIncrement();
               // treasuries.set(treasuryNumber,treasuries.get(treasuryNumber) + 1);
            }

        }
        try {
            System.out.println("I am on the barrier");
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
