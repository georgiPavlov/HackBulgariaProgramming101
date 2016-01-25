package week09;

import java.util.*;

/**
 * Created by georgipavlov on 25.01.16.
 */
public class BlockingQueue  {
    static final Queue t = new LinkedList<>();
    static BlockingQueue blockingQueue = new BlockingQueue();
    private static final int MAX_SIZE = 5;



    public void putTo(Object addObject) throws InterruptedException {
        synchronized (t){
        while (t.size() == MAX_SIZE){
            System.out.println("I am waiting producer");
            wait();
        }

            t.add(addObject);
            t.notifyAll();
        }
    }

    public synchronized void n(){
        t.notifyAll();
    }

    public Object pollTo() throws InterruptedException {
        synchronized (t){
        while (t.isEmpty()){
            System.out.println("Im am waiting consumer");
            wait();
        }
        t.notifyAll();
        return t.poll();
        }
    }

    static class Producer extends Thread{

        private String l;
        Producer(String l){
            this.l = l;
        }
        @Override
        public void run() {

            try {
                System.out.println("starting producer....");
                blockingQueue.putTo(l);
                System.out.println("producer work done.... "  + l);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    static class Consumer extends Thread{



        @Override
        public void run() {
            blockingQueue = new BlockingQueue();
            try {
                System.out.println("Starting consumer...");
                Object object = blockingQueue.pollTo();
                System.out.println("consumer work done... " + object);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


    public static void main(String[] args) throws InterruptedException {


      Producer p= new Producer("one");
        Consumer c = new Consumer();
        c.start();
        p.start();
        c.join();
        p.join();

    }

}
