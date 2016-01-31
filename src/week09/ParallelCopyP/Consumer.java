package week09.ParallelCopyP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class Consumer extends DataBase implements Runnable{
    private static Consumer consumer;
    public static boolean loop = true;
    public static List<ConsumerChild> threads;


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
                updateThreads(maxThread,value);
                value=maxThread;
            }
        }
    }

    private void updateThreads(int value,int value2){
        if(value > MAX_THREADS){
            maxThread=value2;
            return;
        }else if(value > threads.size()){
            addThreads(value-threads.size());
        }else {
            removeThreads(threads.size() -value);
        }

    }


    public void addThreads(int value){
        for (int i = value; i > 0; i--) {
            ConsumerChild child = new ConsumerChild();
            child.start();
            threads.add(child);
        }
    }

    public void removeThreads(int value){

            for (int i = 0; i < threads.size(); i++) {
              if(value == 0){
                  return;
              }
                threads.get(i).setLoop(false);
                value--;
            }
    }
}
