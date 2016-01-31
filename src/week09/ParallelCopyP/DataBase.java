package week09.ParallelCopyP;

import java.util.Queue;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class DataBase {
    protected static Queue<Entry> files;
    protected static Integer maxThread;
    protected static Consumer consumer;
    protected static final int MAX_THREADS = (Runtime.getRuntime().availableProcessors() * 6) - 3;

}
