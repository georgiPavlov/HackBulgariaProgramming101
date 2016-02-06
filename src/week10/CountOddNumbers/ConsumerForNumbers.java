package week10.CountOddNumbers;

/**
 * Created by georgipavlov on 05.02.16.
 */
public class ConsumerForNumbers extends Thread {
    @Override
    public void run(){
        System.out.println("odd numbers count: " + DB_Numbers.count);
    }

}
