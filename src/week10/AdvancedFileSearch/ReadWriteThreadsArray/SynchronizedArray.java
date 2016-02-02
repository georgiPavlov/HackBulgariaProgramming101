package week10.AdvancedFileSearch.ReadWriteThreadsArray;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class SynchronizedArray {

    private ArrayList<ReentrantReadWriteLock> locks;
    private ArrayList<Integer> numbers;
    private int sectorSize;

    public SynchronizedArray(int sectors , int size, ArrayList<Integer> numbers,
                             ArrayList<ReentrantReadWriteLock> locks){
        this.locks =locks;
        this.numbers = numbers;
        sectorSize = size / sectors;
    }


    public void write(int index){
        locks.get(index / sectorSize).writeLock().lock();
        numbers.add(index);
        locks.get(index / sectorSize).writeLock().unlock();
    }

    public int read(int index){
        int a;
        locks.get(index / sectorSize).readLock().lock();
         a= numbers.get(index);
        locks.get(index / sectorSize).readLock().unlock();
        return a;
    }


}
