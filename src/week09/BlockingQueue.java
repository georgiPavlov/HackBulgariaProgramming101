package week09;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by georgipavlov on 25.01.16.
 */
public class BlockingQueue  {
    static Queue t = new LinkedList<>();
    private static final int MAX_SIZE = 5;


    public  synchronized void putTo(Object addObject) throws InterruptedException {
        while (t.size() == MAX_SIZE){
            System.out.println("I am waiting produser");
            wait();
        }
        t.add(addObject);
    }

    public synchronized Object pollTo() throws InterruptedException {
        while (t.isEmpty()){
            System.out.println("Im am waiting consumer");
            wait();
        }
        return t.poll();
    }

    static class Produser extends Thread{

        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {

    }

}
