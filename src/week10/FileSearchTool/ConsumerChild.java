package week10.FileSearchTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class ConsumerChild extends Thread{
    private boolean loop = true;
    Scanner scanner;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop){
            copy();
        }

    }


    public void copy(){
        synchronized (DataBaseFile.files){
            while (DataBaseFile.files.size() == 0){
                try {
                    DataBaseFile.files.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Entry entry = DataBaseFile.files.poll();
            if(entry.isNewThread()){
                    synchronized (DataBaseFile.consumer){
                        DataBaseFile.maxThread++;
                        DataBaseFile.consumer.notifyAll();
                    }
                }
                if(!entry.getLink().endsWith(".txt")){
                    return;
                }
            try {
                readFrom(new Scanner(new File(entry.getLink())),entry.getLink());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //System.out.println(entry.getLink() + " is link");



        }

    }

    public void readFrom(Scanner scanner, String link){
        int count = 1;
        while (scanner.hasNext()){
            if(scanner.nextLine().contains(DataBaseFile.wordsSecunce)){
                System.out.println("secuense found in line: " + count + " link: " + link );
            }
            count++;
        }

    }
}
