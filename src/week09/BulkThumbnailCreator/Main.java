package week09.BulkThumbnailCreator;

/**
 * Created by georgipavlov on 30.01.16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataBase.widht = 150;
        DataBase.height = 150;
        Thread thread = new Thread(new BulkThumbnail("/home/georgipavlov/TestImage/"));
        thread.start();
        thread.join();
        System.out.println("finish");
    }
}
