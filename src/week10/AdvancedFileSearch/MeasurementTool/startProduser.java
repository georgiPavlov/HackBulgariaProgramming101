package week10.AdvancedFileSearch.MeasurementTool;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class startProduser implements Runnable{
    int j;
    DB<Integer> db;


    public startProduser(int j,DB<Integer> db) {
        System.out.println(j);
        this.j  =j;
        this.db =db;
    }


    @Override
    public void run() {
       // System.out.println("fgff");
        for (int i = 0; i < j ; i++) {
           // System.out.println("fdfg");
            Thread t =new Thread(new ProducerT<Integer>(db,j));
            t.start();
        }
    }
}
