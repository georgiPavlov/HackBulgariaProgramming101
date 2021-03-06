package week09.BulkThumbnailCreator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by georgipavlov on 30.01.16.
 */
public class Producer extends DataBase implements Runnable{

    private static Producer producer;
    public static boolean loop = true;
    public static boolean put = false;
    public static String path;


    private Producer(){}

    public static Producer createProduser(){
        if(producer == null){
            producer = new Producer();
            return producer;
        }else {
            return null;
        }
    }




    @Override
    public void run() {
        while (loop){
            synchronized (this){
            while (links.size() == 0){
                try {
                    System.out.println("producer is waiting");
                    producer.wait();
                } catch (InterruptedException e) {
                    System.out.println("producer stopped");
                    return;
                }
            }
                try {
                    putIn(links.poll());
                    System.out.println("producer produced picture");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("notify consumer");
                synchronized (consumer){
                consumer.notifyAll();
                }
            }
        }

    }

    private void putIn(String path) throws IOException {
        BufferedImage img = new BufferedImage(widht, height, BufferedImage.TYPE_INT_RGB);
        img.createGraphics().drawImage(ImageIO.read(new File(path)).
                getScaledInstance(widht, height, Image.SCALE_SMOOTH),0,0,null);
        images.add(new EntryForImage(img,path));
    }


}
