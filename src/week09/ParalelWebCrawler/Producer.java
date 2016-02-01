package week09.ParalelWebCrawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import week09.BulkThumbnailCreator.DataBase;

import java.io.IOException;
import java.util.HashSet;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by georgipavlov on 01.02.16.
 */
public class Producer extends DataBaceWeb implements Runnable{
    public  static final int MAX_COUNT_OF_PAGES = 10;
    public boolean loop = true;


    public void produce(String link) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(link);
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        entities.add(entity);
        synchronized (entities){
            entities.notifyAll();
        }

    }


    @Override
    public void run() {
        while (loop){
            while (link.size() == 0){
                synchronized (link){
                    try {
                        link.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                produce(link.poll());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
