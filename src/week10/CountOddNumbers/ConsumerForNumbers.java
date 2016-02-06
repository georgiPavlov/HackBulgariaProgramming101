package week10.CountOddNumbers;

/**
 * Created by georgipavlov on 05.02.16.
 */
public class ConsumerForNumbers extends Thread {
    long time;

    public ConsumerForNumbers(long time) {
        this.time = time;
    }

    @Override
    public void run(){
       /* int result =0;
        for (int i = 0; i < DB_Numbers.treasuries.size() ; i++) {
            result += DB_Numbers.treasuries.get(i);
        }*/
        System.out.println("odd numbers count: " + DB_Numbers.count);
        //System.out.println("odd numbers count: " + result);
        System.out.println("time: " + (System.currentTimeMillis() - time ));
    }

}
