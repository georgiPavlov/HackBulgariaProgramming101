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
    AtomicInteger countProducers = new AtomicInteger();
    AtomicInteger countConsumers = new AtomicInteger();
    AtomicInteger finishProducing = new AtomicInteger();
    AtomicInteger finishConsuming = new AtomicInteger();
    public int produserCount;
    boolean finishProducers = false;
    boolean isFinishConsumers  =false;
    private long maxElements;
    private long elementsInQueue;

    public long getElementsInQueue() {
        return elementsInQueue;
    }

    public AtomicInteger getCountProdusers() {
        return countProducers;
    }

    public AtomicInteger getCountConsumers() {
        return countConsumers;
    }

    public long getMaxElements() {
        return maxElements;
    }



    public DB(long maxElements) {
        this.elementsInQueue = maxElements;
        this.maxElements = maxElements;
        this.queueT =  new ConcurrentLinkedQueue<>();
        if(entries == null){
         entries = new ConcurrentLinkedQueue<>();
        }
    }

    public DB(long elementsInQueue,long maxElements){
        this.maxElements = maxElements;
        this.elementsInQueue = elementsInQueue;
        this.queueT =  new ConcurrentLinkedQueue<>();
        if(entries == null){
            entries = new ConcurrentLinkedQueue<>();
        }
    }

    public void factoryReset(){
         countProducers.getAndSet(0);
         countConsumers.getAndSet(0);
         finishProducers = false;
         isFinishConsumers = false;
         finishProducing.getAndSet(0);
         finishConsuming.getAndSet(0);
    }

    public Queue<T> getQueueT() {
        return queueT;
    }

    public Queue<Entry> getEntries() {
        return entries;
    }
}
