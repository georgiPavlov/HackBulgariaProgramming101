package week09.BulkThumbnailCreator;

/**
 * Created by georgipavlov on 30.01.16.
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new BulkThumbnail("/home/georgipavlov/TestImage/"));
        thread.start();
    }
}
