package week10.MeasurementTool;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class StartConsumer implements Runnable{
    int k;
    DB<Integer> db;

    public StartConsumer(int k, DB<Integer> db){
        System.out.println("Consumer count constructor : " + k);
        this.k =k;
        this.db =db;

    }


    @Override
    public void run() {
      //  System.out.println("fgdfgd");
        for (int i = 0; i < k; i++) {
        //    System.out.println("dfd");
            Thread t = new Thread(new ConsumerT<Integer>(db));
            t.start();

        }
    }
}
