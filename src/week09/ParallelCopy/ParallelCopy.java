package week09.ParallelCopy;

import week09.BulkThumbnailCreator.*;
import week09.BulkThumbnailCreator.Consumer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class ParallelCopy extends DataBase implements Runnable {
    private static ParallelCopy parallelCopy;
    private String directory;
    private String target;
    private static final int MAX_THREADS = Runtime.getRuntime().availableProcessors() + 5;

    private ParallelCopy(){}

    public ParallelCopy createParallelCopy(String directory,String target){
        if(parallelCopy == null){
            files = new ConcurrentLinkedQueue<>();
            this.target = target;
            this.directory=directory;
            parallelCopy = new ParallelCopy();
            return parallelCopy;
        }
        return null;
    }


    @Override
    public void run() {


    }

    public void createList(String string ){
        System.out.println("starting search");
        boolean big =false;
        Path path = Paths.get(string);
        File file = new File(string);
        if (!file.isDirectory()){
            if((double)file.length()/1024 > 102400){
                big = true;
            }
            Entry entry= new Entry(big,target + path.getFileName().toString());
            files.add(entry);
            return;
        }
        String[] children = file.list();
        File child;
        big = false;

        for (int i = 0; i <children.length ; i++) {
            child = new File(path.toString() + "/" + children[i]);
            if(file.isDirectory()){
                files.add(new Entry(big,target + "/" + children[i]));
                createList(string + "/" + children[i]);
            }else {
                if((double)file.length()/1024 > 102400){
                    big = true;
                }
                files.add(new Entry(big,target + "/" + children[i]));

            }
            //synchronized (){

          //  }
            big= false;
        }
    }
}
