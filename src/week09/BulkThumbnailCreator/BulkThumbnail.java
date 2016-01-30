package week09.BulkThumbnailCreator;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by georgipavlov on 30.01.16.
 */
public class BulkThumbnail extends DataBase implements Runnable{
    private static boolean start = true;
    public static boolean recursive  = false;
    private String link;
    private static final int MAX_THREADS = Runtime.getRuntime().availableProcessors() + 5;
    private Thread threadProducer;
    private Thread threadConsumer;

    BulkThumbnail(String link){
        this.link = link;
    }

    @Override
    public void run() {
       setStart();
        search(link);

        while ((!(threadProducer.getState() == Thread.State.WAITING)) ||
                (!(threadConsumer.getState() == Thread.State.WAITING))){}

            Producer.loop = false;
            Consumer.loop = false;

    }

    private void setStart(){
        if(start){
            start =false;
            producer= Producer.createProduser();
            consumer = Consumer.createConsumer();
            threadProducer = new Thread(producer);
            threadConsumer = new Thread(consumer);
            System.out.println("starting producer");
            threadProducer.start();
            System.out.println("starting consumer");
            threadConsumer.start();
        }
    }

    private void search(String link){
        System.out.println("starting search");
        Path path = Paths.get(link);
        File file = path.toFile();
        if (!file.isDirectory()){
            if(!link.endsWith(".jpg")){
                return;
            }
            links.add(link);
            synchronized (producer){
            producer.notifyAll();
            }
            return;
        }
        String[] children = file.list();
        File child;

        for (int i = 0; i <children.length ; i++) {
            child = new File(link + "/" + children[i]);
            if(child.isDirectory() && recursive){
                search(child.getAbsolutePath());
                continue;
            }else if(child.getAbsolutePath().endsWith(".jpg")){
                links.add(child.getAbsolutePath());
                System.out.println("find image " + child.getAbsolutePath());
                synchronized (producer){
                    System.out.println("notify produser");
                    producer.notifyAll();
                }
            }
        }

    }


}
