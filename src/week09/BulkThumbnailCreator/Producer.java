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

    Producer producer;
    public static boolean loop = true;
    public static boolean put = false;
    public static String path;


    private Producer(){}

    public Producer createProduser(){
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
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                try {
                    putIn(links.poll());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.notifyAll();
            }
        }

    }

    private void putIn(String path) throws IOException {
        BufferedImage img = new BufferedImage(widht, height, BufferedImage.TYPE_INT_RGB);
        img.createGraphics().drawImage(ImageIO.read(new File("test.jpg")).
                getScaledInstance(widht, height, Image.SCALE_SMOOTH),0,0,null);
        images.add(new EntryForImage(img,path));
    }


}
