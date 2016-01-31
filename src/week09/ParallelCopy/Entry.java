package week09.ParallelCopy;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class Entry {
     private boolean newThread =false;
     private String link;
     private String target;

    private  boolean directory;



    public Entry(boolean newThread, boolean directory, String link, String target) {
        this.newThread = newThread;
        this.link = link;
        this.target = target;
        this.directory = directory;


    }

    public boolean isNewThread() {
        return newThread;
    }

    public String getLink() {
        return link;
    }

    public String getTarget() {
        return target;
    }

    public boolean isDirectory() {
        return directory;
    }
}
