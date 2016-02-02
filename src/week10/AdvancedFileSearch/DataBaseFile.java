package week10.AdvancedFileSearch;


import java.util.Queue;

/**
 * Created by georgipavlov on 02.02.16.
 */
public class DataBaseFile {
    protected static Queue<Entry> files;
    protected static Integer maxThread;
    protected static Consumer consumer;
    protected static final int MAX_THREADS = (Runtime.getRuntime().availableProcessors() * 6) - 3;
    protected static String wordsSecunce;
}
