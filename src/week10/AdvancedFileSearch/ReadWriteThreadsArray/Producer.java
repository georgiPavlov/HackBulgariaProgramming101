package week10.AdvancedFileSearch.ReadWriteThreadsArray;

/**
 * Created by georgipavlov on 02.02.16.
 */
public class Producer extends Thread {
     DataBace dataBace;
     long start;
     long end;
     boolean type ;



    Producer(DataBace dataBace,long start,long end,boolean type){
        this.start = start;
        this.end = end;
        this.dataBace =dataBace;
        this.type = type;

    }

    @Override
    public void run() {
        if(type) {
            put();
        }else {
            get();
        }
    }

    private void get() {
        for (long i = start; i < end; i++) {
            dataBace.getIndex(i);
        }
        DataBace.finishedSegmentsRead.incrementAndGet();
    }

    public void put(){
        for (long i = start; i < end; i++) {
            dataBace.setIndex(i);
        }
        DataBace.finishedSegmentsWrite.incrementAndGet();
    }
}
