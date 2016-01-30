package week09.BulkThumbnailCreator;

import sun.plugin.javascript.navig.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by georgipavlov on 30.01.16.
 */
public class Consumer extends DataBase implements Runnable {
    Consumer consumer;
    public static boolean loop = true;


    private Consumer(){}

    public Consumer createConsumer(){
        if(consumer == null){
            consumer = new Consumer();
            return consumer;
        }else {
            return null;
        }
    }

    @Override
    public void run() {
        while (loop){
           pollIn();
        }
    }


    public synchronized void pollIn(){
        while (images.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        EntryForImage entry = images.poll();
        Path path = Paths.get(entry.getLinkTo());
        if(Files.notExists(path)){
            File file = path.toFile();
            file.mkdir();
        }
        try {
            ImageIO.write(entry.getImage(), "jpg", new File(entry.getLinkTo() + entry.getNameTo()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
