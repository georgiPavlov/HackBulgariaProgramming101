package week10.CountOddNumbers;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by georgipavlov on 05.02.16.
 */
public class DB_Numbers {
    protected static AtomicLong count = new AtomicLong();
    protected static CyclicBarrier barrier;
    protected static int threadCount;

    public static void set_Count(AtomicLong count) {
        DB_Numbers.count = count;
    }

    public static void setBarrier(CyclicBarrier barrier) {
        DB_Numbers.barrier = barrier;
    }

    public static void setThreadCount(int threadCount) {
        DB_Numbers.threadCount = threadCount;
    }
}
