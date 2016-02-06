package week10.CountOddNumbers;

import java.util.Random;

/**
 * Created by georgipavlov on 05.02.16.
 */
public class ProduserForNumbers extends DB_Numbers implements Runnable{
     private int threadCount;
     private long n = 2_000_000_000;
     private Random random;


    ProduserForNumbers(int threadCount){
        this.threadCount = threadCount;
        random = new Random();
    }




    @Override
    public void run() {
        int number;
        for (int i = 0; i < n ; i++) {
             number = random.nextInt(200000);
            if( (number & 1) != 0 ){
                count++;
            }

        }

    }
}
