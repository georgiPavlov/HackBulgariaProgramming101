package week09.ParallelCopyP;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.nio.file.StandardCopyOption.*;
/**
 * Created by georgipavlov on 31.01.16.
 */
public class ConsumerChild extends Thread{
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop){
         copy();
        }

    }


    public  void copy(){
        synchronized (DataBase.files){
            while (DataBase.files.size() == 0){
                try {
                    DataBase.files.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Entry entry = DataBase.files.poll();
            if(entry.isDirectory()){
                System.out.println("making dir " + entry.getLink() +" :link " + entry.getTarget() );
                File file = new File(entry.getTarget() + entry.getLink());
                file.mkdir();
            }else {
                if(entry.isNewThread()){
                    synchronized (DataBase.consumer){
                        DataBase.maxThread++;
                        DataBase.consumer.notifyAll();
                    }
                }
                try {
                    System.out.println(entry.getTarget() + " this is the target"  + entry.getLink() + " is link");
                    Files.copy(Paths.get(entry.getLink()),Paths.get(entry.getTarget()) ,
                            StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
