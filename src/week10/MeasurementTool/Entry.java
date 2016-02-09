package week10.MeasurementTool;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class Entry {
    private long time;
    private long size;
    private long produsersMax;
    private long consumersMax;
    private long elements;

    public long getElements() {
        return elements;
    }

    public Entry(long time, long size, long produsersMax, long consumersMax,long elements) {
        this.time = time;
        this.size = size;
        this.produsersMax = produsersMax;
        this.consumersMax = consumersMax;
        this.elements = elements;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getProdusersMax() {
        return produsersMax;
    }

    public void setProdusersMax(long produsersMax) {
        this.produsersMax = produsersMax;
    }

    public long getConsumersMax() {
        return consumersMax;
    }

    public void setConsumersMax(long consumersMax) {
        this.consumersMax = consumersMax;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "time=" + time +
                ", size=" + size +
                ", produsersMax=" + produsersMax +
                ", consumersMax=" + consumersMax +
                " elements: " + elements +
                '}';
    }
}
