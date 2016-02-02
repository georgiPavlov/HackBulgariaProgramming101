package week10.AdvancedFileSearch.ReadWriteThreadsArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by georgipavlov on 02.02.16.
 */
public class DataBace {
    private ArrayList<Long> nums;
    private ArrayList<ReentrantReadWriteLock> locks;
    private SynchronizedArray array;
     static AtomicInteger finishedSegmentsRead = new AtomicInteger();
     static AtomicInteger finishedSegmentsWrite = new AtomicInteger();
    private long segmentBig = array.getSectorSize();

    public long getSegmentBig() {
        return segmentBig;
    }

    public Long  getIndex(long index ){
        return array.read(index);
    }

    public void setIndex(long index){
        array.write(index);
    }

    public DataBace(long size, int sectors){
        nums = new ArrayList<>();
        locks = new ArrayList<>();
        createArray(size);
        createLocks(sectors);
        array = new SynchronizedArray(sectors,size,nums,locks);
        finishedSegmentsRead.set(0);
        finishedSegmentsWrite.set(0);
    }

    private void createArray(long size) {
        for (long i = 0; i < size; i++) {
            nums.add(null);
        }
    }

   private void createLocks(int sectors){
        for (int i = 0; i < sectors; i++) {
            locks.add(new ReentrantReadWriteLock());
        }
    }


}
