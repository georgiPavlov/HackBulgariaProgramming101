package week10.MeasurementTool;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class Tool implements Runnable {
    static final int MAX_THREADS = Runtime.getRuntime().availableProcessors() * 2;


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

        for (long i = 1000; i <= 1000; i *= 10) {
            System.out.println("loop i");
            for (int z = 10; z <= 100; z*=10) {
                DB<Integer> db = new DB<>(i,z);
                System.out.println(db.queueT.size() + " size");
                for (int j = 1; j < MAX_THREADS; j++) {
                    System.out.println("loop j");
                    for (int k = 1; k < MAX_THREADS + 1; k++) {
                        db.factoryReset();
                        time = System.currentTimeMillis();
                        new Thread(new StartProducer(j, db)).start();
                        System.out.println("loop k");
                        new Thread(new StartConsumer(k, db)).start();
                        while ((!(db.finishProducing.getAndAdd(0) == j)) &&
                                (!(db.finishConsuming.getAndAdd(0) == k))) {
                            //  System.out.println("count in db for producers " + j +" "  +  db.finishProducing.getAndAdd(0));
                            // System.out.println("count in db for consumers " + k +" " +   db.finishConsuming.getAndAdd(0) );
                            //System.out.println("loop");
                        }
                        System.out.println("creating an entry...");
                        time = System.currentTimeMillis() - time;
                        System.out.println("reset");
                        createEntry(i, j, k, time,z);
                    }
                }
            }
        }


    }
}
