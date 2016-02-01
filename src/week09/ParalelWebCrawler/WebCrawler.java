package week09.ParalelWebCrawler;


import week09.BulkThumbnailCreator.*;
import week09.BulkThumbnailCreator.Producer;

import java.util.ArrayList;

/**
 * Created by georgipavlov on 01.02.16.
 */
public class WebCrawler extends DataBaceWeb implements Runnable{

    private static final int MAX_COUNT_OF_PAGES = 15;
    private String word;
    private boolean found = false;
    private String web;
    private ArrayList<week09.ParalelWebCrawler.Producer> produsers;
    private ArrayList<Cosumer> consumers;

    public WebCrawler(String word,String web){
        produsers = new ArrayList<>();
        consumers = new ArrayList<>();
        DataBaceWeb.word = word;
        this.web = web;
    }


    @Override
    public void run() {
        start();
        while (!found){}
        stop();

    }

    private void stop() {
        for (int i = 0; i <MAX_THREADS ; i++) {
            produsers.get(i).loop = false;
            consumers.get(i).loop = false;
        }
    }

    private void start() {
        startProducers();
        startConsumer();

    }

    private void startConsumer() {
        for (int i = 0; i < MAX_THREADS; i++) {
            Cosumer consumer = new Cosumer();
            Thread temp = new Thread(consumer);
            temp.start();
            consumers.add(consumer);

        }

    }
    private void startProducers(){
        for (int i = 0; i < MAX_THREADS; i++) {
            week09.ParalelWebCrawler.Producer p = new week09.ParalelWebCrawler.Producer();
            Thread temp = new Thread(p);
            temp.start();
            produsers.add(p);

        }
    }


}

