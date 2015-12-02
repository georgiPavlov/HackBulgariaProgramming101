package week03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by georgipavlov on 02.12.15.
 */
public class Intersect {
    public static Collection<Integer> intersect(Collection<Integer> firstList,
                                                Collection<Integer> secondList,Collection<Integer> thirdList) {
        Collection<Integer> intersect = new ArrayList<Integer>();
        for (Integer item : firstList) {
            if (secondList.contains(item) && thirdList.contains(item)) {
                intersect.add(item);
            }
        }
        return intersect;
    }

    public static void printList(ArrayList<Integer> list) {
        System.out.print("{ ");
        for (Integer item : list) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        ArrayList<Integer> firstList = new ArrayList<Integer>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(5);
        System.out.print("firstList = ");
        printList(firstList);

        ArrayList<Integer> secondList = new ArrayList<Integer>();
        secondList.add(2);
        secondList.add(4);
        secondList.add(6);
        System.out.print("secondList = ");
        printList(secondList);

        ArrayList<Integer> thirdList = new ArrayList<Integer>();
        secondList.add(2);
        secondList.add(4);
        System.out.print("thirdList = ");
        printList(secondList);

        ArrayList<Integer> intersectList = new ArrayList<Integer>();
        intersectList.addAll(firstList);
        intersectList.retainAll(secondList);
        System.out.print("intersect = ");
        printList(intersectList);

    }
}
