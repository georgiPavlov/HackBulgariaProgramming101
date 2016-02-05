package week10.MeasurementTool;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class Tool {
    static final int MAX_THREADS = Runtime.getRuntime().availableProcessors()*2  ;


    public static void main(String[] args) {
        long time;
        System.out.println("starting");

        for (long i = 1000; i <= 1000; i*=10) {
            System.out.println("loop i");
            DB<Integer> db = new DB<>(i);
            time = System.currentTimeMillis();
            for (int j = 1; j < MAX_THREADS; j++) {
                System.out.println("loop j");
                new Thread(new startProduser(j,db)).start();
                for (int k =1; k <MAX_THREADS ; k++) {
                    System.out.println("loop k");
                     new Thread(new startConsumer(k,db)).start();
                    while ((!db.finishProducers) && (!db.isFinishConsumers)){
                        //System.out.println("looping.....");
                    }
                    System.out.println("creating an entry...");
                    time = System.currentTimeMillis() - time;
                    createEntry(i,j,k,time);
                    db.factoryReset();
                    System.out.println("reset");
                }
            }
        }

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
        printTable();
    }

    private static void printTable() {
        for (int i = 0; i < DB.entries.size(); i++) {
            System.out.println(DB.entries.poll());
        }
    }

    private static void createEntry(long i, int j, int k,long time) {
        DB.entries.add(new Entry(time,i,j,k));
    }


}
