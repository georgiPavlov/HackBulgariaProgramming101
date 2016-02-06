package week10.MeasurementTool;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class Tool implements Runnable {
    static final int MAX_THREADS = Runtime.getRuntime().availableProcessors()*2 ;


    public static void main(String[] args) {
        Thread thread = new Thread(new Tool());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
        printTable();
    }

    private static void printTable() {
        int n = DB.entries.size();
        for (int i = 0; i < n; i++) {
            System.out.println(DB.entries.poll());
        }
    }

    private static void createEntry(long i, int j, int k, long time,int z) {
        DB.entries.add(new Entry(time, i, j, k,z));
    }


    @Override
    public void run() {
        long time;
        System.out.println("starting");

        for (long sizeOfElements = 1000; sizeOfElements <= 1000000000; sizeOfElements *= 10) {
            System.out.println("loop i");
            for (int memory = 10; memory <= 100; memory*=10) {
                DB<Integer> db = new DB<>(sizeOfElements,memory);
              //  System.out.println(db.queueT.size() + " size");
                for (int producersCount = 1; producersCount < MAX_THREADS; producersCount++) {
                    System.out.println("loop j " + producersCount);
                    for (int consumersCount = 1; consumersCount < MAX_THREADS + 1; consumersCount++) {
                        time = startTests(producersCount,consumersCount,db);
                        System.out.println("reset");
                        createEntry(sizeOfElements, producersCount, consumersCount, time,memory);
                    }
                }
            }
        }


    }


    public long startTests(int producersCount,
                           int consumersCount,DB<Integer> db){
        long time;
        db.produserCount = producersCount;
        time = System.currentTimeMillis();
        new Thread(new StartProducer(producersCount, db)).start();
        System.out.println("loop k " + consumersCount);
        new Thread(new StartConsumer(consumersCount, db)).start();
        while ((!(db.finishProducing.getAndAdd(0) >= producersCount)) &&
                (!(db.finishConsuming.getAndAdd(0) >= consumersCount))) {
            //  System.out.println("count in db for producers " + j +" "  +  db.finishProducing.getAndAdd(0));
            // System.out.println("count in db for consumers " + k +" " +   db.finishConsuming.getAndAdd(0) );
            //System.out.println("loop");
        }
        //System.out.println("creating an entry...");
        time = System.currentTimeMillis() - time;
        db.factoryReset();
        return time;
    }
}
