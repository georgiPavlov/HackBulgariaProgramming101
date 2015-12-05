package week03.MyHashTable;

/**
 * Created by georgipavlov on 05.12.15.
 */
public class Entry {
    private String key;
    private Integer value;

    public Entry() {
        this.key=null;
        this.value = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
