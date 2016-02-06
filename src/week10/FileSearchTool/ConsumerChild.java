package week10.FileSearchTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
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
            search();
        }

    }


    public void search(){
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

    private void readFrom(Scanner scanner, String link){
        int tempCount=0;
        int countReturn =0;
        Queue<String> wordsQueue = sequence();

        int count = 1;
        int indexOf=0;
        boolean firstMatch = true;
        while (scanner.hasNext()){
            String result = scanner.nextLine();
            if(result.contains(DataBaseFile.wordsSequence)){
                System.out.println("sequence found in line: " + count + " link: " + link );
            }else {
                if(tempCount + 1 != count){
                    wordsQueue = sequence();
                    tempCount=0;
                    firstMatch = true;
                }
                int size =  wordsQueue.size();
                for (int i = 0; i < size; i++) {
                    if(result.contains(wordsQueue.peek()) && result.indexOf(wordsQueue.peek(),0) > indexOf){
                        indexOf = result.indexOf(wordsQueue.peek(),0);
                        wordsQueue.poll();
                    }else {
                        if(size == wordsQueue.size()){
                            wordsQueue = sequence();
                            tempCount=0;
                            firstMatch = true;
                        }else {
                            if(firstMatch){
                                countReturn = count;
                                firstMatch = false;
                            }
                        tempCount = count;
                        }
                        break;
                    }
                }
                if(wordsQueue.isEmpty()){
                System.out.println("sequence found in line: " + countReturn + " link: " + link );
                }
            }
            count++;
        }

    }

    private Queue<String> sequence(){
        String[] words = DataBaseFile.wordsSequence.split("[ ]+");
        Queue<String> wordsQueue = new LinkedList<>();
        wordsQueue.addAll(Arrays.asList(words));
        return wordsQueue;
    }




}
