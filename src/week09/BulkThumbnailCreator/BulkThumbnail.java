package week09.BulkThumbnailCreator;

/**
 * Created by georgipavlov on 30.01.16.
 */
public class BulkThumbnail extends DataBase implements Runnable{
    static boolean start = true;

    @Override
    public void run() {
       setStart();




    }

    public void setStart(){
        if(start){
            start =false;
            producer= producer.createProduser();
            consumer = consumer.createConsumer();
            Thread threadProduer = new Thread(producer);
            Thread threadConsumer = new Thread(consumer);
            threadProduer.start();
            threadConsumer.start();
        }
    }
}
