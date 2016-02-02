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
    private ArrayList<Integer> nums;
    private ArrayList<ReentrantReadWriteLock> locks;
    private SynchronizedArray array;
    private static AtomicInteger finishedSegmentsRead = new AtomicInteger();
    private static AtomicInteger finishedSegmentsWrite = new AtomicInteger();


    public Integer  getIndex( int index ){
        return array.read(index);
    }

    public void setIndex(int index){
        array.write(index);
    }

    public DataBace(int size, int sectors){
        nums = new ArrayList<>();
        createArray(size);
        createLocks(sectors);
        array = new SynchronizedArray(size,sectors,nums,locks);
    }

    private void createArray(int size) {
        for (int i = 0; i < size; i++) {
            nums.add(null);
        }
    }

   private void createLocks(int sectors){
        for (int i = 0; i < sectors; i++) {
            locks.add(new ReentrantReadWriteLock());
        }
    }


}
