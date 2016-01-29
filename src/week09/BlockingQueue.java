package week09;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by georgipavlov on 25.01.16.
 */
public class BlockingQueue  {
    Lock lock =new  ReentrantLock();
    private Queue t = new LinkedList<>();

    private static final int MAX_SIZE = 5;



    public synchronized void putTo(Object addObject) throws InterruptedException {

        while (t.size() == MAX_SIZE){
            System.out.println("I am waiting producer");
            wait();
        }
           if (!lock.tryLock()){
               lock.lock();
               t.add(addObject);
               lock.unlock();
           }

         notifyAll();

    }



    public synchronized Object pollTo() throws InterruptedException {

        while (t.isEmpty()){
            System.out.println("Im am waiting consumer");
            wait();
        }
        notifyAll();
        while (lock.tryLock()){}
        return t.poll();

    }

    static class Producer extends Thread{
        BlockingQueue p;
        private String l;
        Producer(String l,BlockingQueue p){
            this.p = p;
            this.l = l;
        }
        @Override
        public void run() {

            try {
                System.out.println("starting producer....");
                p.putTo(l);
                System.out.println("producer work done.... "  + l);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    static class Consumer extends Thread{

        BlockingQueue p;
        public Consumer(BlockingQueue p){
            this.p = p;
        }

        @Override
        public void run() {

            try {
                System.out.println("Starting consumer...");
                Object object = p.pollTo();
                System.out.println("consumer work done... " + object);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    public static void main(String[] args) throws InterruptedException {

      BlockingQueue g = new BlockingQueue();
      Producer p= new Producer("one",g);
        Consumer c = new Consumer(g);
        c.start();
        p.start();


    }

}
