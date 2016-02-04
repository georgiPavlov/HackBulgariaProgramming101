package week10.MeasurementTool;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class DB<T> {
    Queue<T> queueT;
    static Queue<Entry> entries;
    AtomicInteger countProdusers = new AtomicInteger();
    AtomicInteger countConsumers = new AtomicInteger();
    boolean finishProdusers = false;
    boolean isFinishConsumers  =false;
    private long maxElements;

    public AtomicInteger getCountProdusers() {
        return countProdusers;
    }

    public AtomicInteger getCountConsumers() {
        return countConsumers;
    }

    public long getMaxElements() {
        return maxElements;
    }



    public DB(long maxElements) {
        this.maxElements = maxElements;
        this.queueT =  new ConcurrentLinkedQueue<>();
        if(entries == null){
         entries = new ConcurrentLinkedQueue<>();
        }
    }

    public Queue<T> getQueueT() {
        return queueT;
    }

    public Queue<Entry> getEntries() {
        return entries;
    }
}
