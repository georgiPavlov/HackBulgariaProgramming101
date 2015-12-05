package week03.MyHashTable;

/**
 * Created by georgipavlov on 05.12.15.
 */
public class Entry<T,E> {
    private T key;
    private E value;

    public Entry() {
        this.key=null;
        this.value = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
