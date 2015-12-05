package week03.MyHashTable;

/**
 * Created by georgipavlov on 05.12.15.
 */
public class Test {


    public static void main(String[] args) {
        MyHashTable<String,Integer> myHashTable = new MyHashTable<>();
        myHashTable.put("one" , 1);
        myHashTable.put("two" , 2);
        myHashTable.put("tree" , 3);
        myHashTable.put("four" , 4);
        System.out.println(myHashTable.containsKey("four"));

    }

}
