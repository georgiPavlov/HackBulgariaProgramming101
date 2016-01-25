package week09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by georgipavlov on 25.01.16.
 */
public class BlockingQueue<T>  {
    Queue<T> t;

    BlockingQueue(){
        t= new LinkedList<>();
    }
    public synchronized void putTo(T addObject){
        t.add(addObject);
    }

    public synchronized T pollTo() throws InterruptedException {
        while (t.isEmpty()){
            wait();
        }
        return t.poll();
    }

}
