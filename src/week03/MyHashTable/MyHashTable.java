package week03.MyHashTable;

import java.util.*;

/**
 * Created by georgipavlov on 05.12.15.
 */
public class MyHashTable<T,E> implements Map<T,E> {
   private ArrayList<MyEntry<T,E>> table;
    private int tableSize;
    private int count=0;



    MyHashTable(){
        tableSize=3;
        table= new ArrayList<>(16);
        init(table);
    }

    private void init(ArrayList table){
        for (int i = 0; i < tableSize; i++) {
            table.add(new MyEntry());
        }
    }

    private int hash(T key){

        int index = (key.hashCode()) % tableSize;
        while (table.get(index).getKey() != null){
            ++index;
            if(index == tableSize-1){
                index=0;
            }
        }
        return index;
    }

    public E put(Object key, Object value){

        double persent = count/tableSize;
        if(persent >= 0.75){
            resize();
        }
        int index =hash((T)key);
        MyEntry<T,E> entry = new MyEntry<>();
        entry.setKey((T)key);
        entry.setValue((E)value);
        table.add(index,entry);
        count++;
        return (E)value;
    }

    @Override
    public E get(Object key){
        int index = key.hashCode() % tableSize;
        while (table.get(index).getKey() != null){
            if(table.get(index).getKey().equals((T)key)){
                return table.get(index).getValue();
            }
            ++index;
            if(index == tableSize-1){
                index=0;
            }
        }
        return null;
    }



    @Override
    public int size() {
        return tableSize;
    }

    @Override
    public boolean isEmpty() {
        if(count == 0){return true;}
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        E value = get((T)key);
        if (value != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < table.size(); i++) {
            if(table.get(i).getKey() != null){
                if(table.get(i).getValue().equals((E)value)){
                    return true;
                }
            }
        }
        return false;
    }



    @Override
    public E remove(Object key) {
        for (int i = 0; i <table.size() ; i++) {
            if(table.get(i).getKey().equals(key)){
                if(hash(prevHash(i)) == hash(nextHash(i)) ){
                    MyEntry<T,E> e = table.get(next(i));
                    table.add(i,e);
                    while(hash(nextHash(i)) == hash(nextHash(i+1))){
                        e = table.get(next(i+1));
                      table.add(next(i),e);
                      i=next(i);
                    }
                    i=next(i);
                    e.setKey(null);
                    e.setValue(null);
                    table.add(i,e);
                    break;
                }
            }
        }
        return null;
    }

    private T prevHash(int i){
         --i;
        if(i<=0){
            i=tableSize + i-1;
        }
        return table.get(i).getKey();
    }

    private T nextHash(int i){
        i = next(i);
        return table.get(i).getKey();
    }

    private int next(int i){
        ++i;
        if(i>=tableSize-1){
            i= i -tableSize-1;
        }
        return i;
    }

    @Override
    public void putAll(Map<? extends T, ? extends E> map) {
        for(Map.Entry<? extends T, ? extends E> mapE: map.entrySet()){
           put(mapE.getKey(),mapE.getValue());
        }
    }

    @Override
    public void clear() {
        table.clear();

    }

    @Override
    public Set<T> keySet() {
        Set<T> set= new TreeSet<>();
        for (int i = 0; i <tableSize ; i++) {
            set.add(table.get(i).getKey());
        }
        return set;
    }

    @Override
    public Collection<E> values() {
        Collection<E> set = new HashSet<>();
        for (int i = 0; i <tableSize ; i++) {
            set.add(table.get(i).getValue());
        }
        return set;
    }

    @Override
    public Set<Entry<T, E>> entrySet() {
        Set<Entry<T, E>> set= new TreeSet<>();
        for (int i = 0; i <tableSize ; i++) {
          final int z =i;
            Entry<T,E> entry = new Entry<T, E>() {

              @Override
              public T getKey() {
                  return table.get(z).getKey();
              }

              @Override
              public E getValue() {
                  return table.get(z).getValue();
              }

              @Override
              public E setValue(E value) {
                  value = table.get(z).getValue();
                  return value;
              }
          };
            set.add(entry);
        }
        return set;
    }

    private void resize(){
        tableSize *=2;
        ArrayList<MyEntry<T,E>> newList =  new ArrayList<>(tableSize);
        init(newList);
        MyEntry<T,E> entry;
        for (int i = 0; i <table.size() ; i++) {
            if(table.get(i).getKey() != null){
                entry=table.get(i);
                int index = hash(entry.getKey());
                newList.add(index, entry);
            }
        }
        table=newList;
    }
}
