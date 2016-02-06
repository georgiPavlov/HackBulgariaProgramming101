package week10.FileSearchTool;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by georgipavlov on 02.02.16.
 */
public class FileSearch extends DataBaseFile implements Runnable {
    private static FileSearch parallelCopy;
    private static String directory;
    private static String target;
    private static final int THREAD_CONSTANT = 8;

    private FileSearch(){}

    public static FileSearch createParallelCopy(String _directory,String _target){
        if(parallelCopy == null){
            files = new ConcurrentLinkedQueue<>();
            target = _target;
            directory = _directory;
            parallelCopy = new FileSearch();
            return parallelCopy;
        }
        return null;
    }


    @Override
    public void run() {
        wordsSequence = target;
        maxThread=1;
        consumer = Consumer.createConsumer();
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        createList(directory);
        synchronized (consumer){
            maxThread = 0;
            consumer.notifyAll();
        }
        Consumer.loop = false;
    }



    public void createList(String string ){
        System.out.println("starting search");
        try {
            findHowManyThreadsToStart(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean big =false;

        Queue<File> visitedDirsQueue = new LinkedList<File>();
        visitedDirsQueue.add(new File(string));
        while (visitedDirsQueue.size() > 0) {
            File currentDir = visitedDirsQueue.remove();
            System.out.println(currentDir.getAbsolutePath());
            File[] children = currentDir.listFiles();
            if (children != null) {
                for (File child : children) {
                    if (child.isDirectory()) {
                        visitedDirsQueue.add(child);
                        continue;
                    }
                    if((double)child.length()/1024 > 102400){
                        big = true;
                    }
                    files.add(new Entry(big,false,child.getAbsolutePath()));
                    synchronized (files){
                        files.notifyAll();
                    }
                    System.out.println(child);
                    big=false;
                }

            }
        }
    }

    public void findHowManyThreadsToStart(String path) throws IOException {
        double size = Files.list(Paths.get(path)).count() / THREAD_CONSTANT;
        if(size < 0){
            maxThread = 1;
        }else if(size > MAX_THREADS ){
            maxThread = MAX_THREADS;
        }else {
            maxThread = (int)size;
        }
        synchronized (consumer){
            consumer.notifyAll();
        }
    }


}
