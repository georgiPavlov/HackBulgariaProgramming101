package week10.MeasurementTool;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class StartProducer implements Runnable{
    int j;
    DB<Integer> db;


    public StartProducer(int j, DB<Integer> db) {
       // System.out.println("producer count construcot: " + j);
        this.j  =j;
        this.db =db;
    }


    @Override
    public void run() {
       // System.out.println("fgff");
        System.out.println("starting j producers "+   j);
        for (int i = 0; i < j ; i++) {
           // System.out.println("fdfg");
            Thread t =new Thread(new ProducerT<Integer>(db,j));
            t.start();
        }
        System.out.println("fibish producers");
    }
}
