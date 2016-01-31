package week09.ParallelCopy;

import week09.BulkThumbnailCreator.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class Consumer extends DataBase implements Runnable{
    private static Consumer consumer;
    public static boolean loop = true;
    public static List<Thread> threads;


    private Consumer(){}

    public static Consumer createConsumer(){
        if(consumer == null){
            consumer = new Consumer();
            threads = new ArrayList<>();
            return consumer;
        }else {
            return null;
        }
    }

    @Override
    public void run() {
        int value = maxThread;
        while (loop){
            synchronized (consumer){
                while (value == maxThread){
                    try {
                        consumer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                updateThreads(maxThread);
            }
        }
    }

    private void updateThreads(int value){

    }
}
