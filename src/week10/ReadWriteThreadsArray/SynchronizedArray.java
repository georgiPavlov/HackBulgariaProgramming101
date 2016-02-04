package week10.ReadWriteThreadsArray;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class SynchronizedArray {

    private ArrayList<ReentrantReadWriteLock> locks;
    private ArrayList<Long> numbers;
    private long sectorSize;

    public long getSectorSize() {
        return sectorSize;
    }

    public SynchronizedArray(int sectors , long size, ArrayList<Long> numbers,
                             ArrayList<ReentrantReadWriteLock> locks){
        this.locks =locks;
        this.numbers = numbers;
        sectorSize = size / sectors;
    }


    public void write(long index){
        locks.get((int)(index / sectorSize)).writeLock().lock();
        numbers.add(index);
        locks.get((int)(index / sectorSize)).writeLock().unlock();
    }

    public long read(long index){
        long a;
        locks.get((int)(index / sectorSize)).readLock().lock();
         a= numbers.get((int)index);
        locks.get((int)(index / sectorSize)).readLock().unlock();
        return a;
    }


}
