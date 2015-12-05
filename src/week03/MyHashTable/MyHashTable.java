package week03.MyHashTable;

import java.util.ArrayList;

/**
 * Created by georgipavlov on 05.12.15.
 */
public class MyHashTable  {
   private ArrayList<Entry> table;
    private int tableSize;
    private int count=0;



    MyHashTable(){
        tableSize=3;
        table= new ArrayList<>(16);
        init(table);
    }

    private void init(ArrayList table){
        for (int i = 0; i < tableSize; i++) {
            table.add(new Entry());
        }
    }

    private int hash(String key){

        int index = (key.hashCode()) % tableSize;
        while (table.get(index).getKey() != null){
            ++index;
            index %=tableSize;
        }
        return index;
    }

    public void put(String key, Integer value){
        double persent = count/tableSize;
        if(persent >= 0.75){
            resize();
        }
        int index =hash(key);
        Entry entry = new Entry();
        entry.setKey(key);
        entry.setValue(value);
        table.add(index,entry);
        count++;
    }

    public Integer get(String key){
        int index = key.hashCode() % tableSize;
        while (table.get(index).getKey() != null){
            if(table.get(index).getKey().equals(key)){
                return table.get(index).getValue();
            }
            ++index;
            index %=tableSize;
        }
        return null;
    }

    public boolean containsKey(String key) {
        if (key == null) {
            return false;
        }
        Integer value = get(key);
        if (value != null) {
            return true;
        }
        return false;
    }

    private void resize(){
        tableSize *=2;
        ArrayList newList =  new ArrayList(tableSize);
        init(newList);
        Entry entry;
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
