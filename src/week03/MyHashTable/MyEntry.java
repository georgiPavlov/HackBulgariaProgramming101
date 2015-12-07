package week03.MyHashTable;

import java.util.Map;

/**
 * Created by georgipavlov on 05.12.15.
 */
public class MyEntry<T,E> implements Map.Entry<T,E> {
    private T key;
    private E value;

    public MyEntry() {
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



    public E setValue(E value) {
        this.value = value;
        return value;
    }
}
