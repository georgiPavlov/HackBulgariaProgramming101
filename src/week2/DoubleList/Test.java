package week2.DoubleList;



/**
 * Created by georgipavlov on 26.11.15.
 */
public class Test {
    public static void main(String[] args) {
        DoubleList one  =new DoubleList();
        one.add(1);
        one.add(2);
        one.add(3);
        //one.add(2);
        //System.out.println(one.getTail());
        //one.add(3);
        //one.add(4);
        //one.print();


        //System.out.println(one.isEmpty());
        System.out.println(one.size());
        //System.out.println(one.get(4));
        one.remove(1);
        System.out.println(one.size());
        //one.clear();
        //System.out.println(one.isEmpty());
    }
}
