package week09.BulkThumbnailCreator;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by georgipavlov on 30.01.16.
 */
public class DataBase {
    protected static Queue<EntryForImage> images = new ConcurrentLinkedQueue<>();
    protected static Queue<String> links = new ConcurrentLinkedQueue<>();
    protected static int height;
    protected static int widht;
    protected static Producer producer;
    protected static Consumer consumer;


}
