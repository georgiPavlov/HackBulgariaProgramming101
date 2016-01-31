package week09.ParallelCopy;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class Entry {
     private boolean newThread =false;
     private String link;

    public Entry(boolean newThread, String link) {
        this.newThread = newThread;
        this.link = link;
    }

    public boolean isNewThread() {
        return newThread;
    }

    public String getLink() {
        return link;
    }
}
