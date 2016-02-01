package week09.ParalelWebCrawler;

import org.apache.http.HttpEntity;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by georgipavlov on 01.02.16.
 */
public class DataBaceWeb {
    protected static  Queue<HttpEntity> entities = new ConcurrentLinkedQueue<>();
    protected static  Queue<String> link = new ConcurrentLinkedQueue<>();
    protected static  String word;
    protected static boolean found = false;

}
