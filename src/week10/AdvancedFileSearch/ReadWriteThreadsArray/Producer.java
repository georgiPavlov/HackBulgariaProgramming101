package week10.AdvancedFileSearch.ReadWriteThreadsArray;

/**
 * Created by georgipavlov on 02.02.16.
 */
public class Producer implements Runnable {
     DataBace dataBace;
     int start;
     int end;
     boolean type ;



    Producer(DataBace dataBace,int start,int end,boolean type){
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
        for (int i = start; i < end; i++) {
            dataBace.getIndex(i);
        }
    }

    public void put(){
        for (int i = start; i < end; i++) {
            dataBace.setIndex(i);
        }

    }
}
