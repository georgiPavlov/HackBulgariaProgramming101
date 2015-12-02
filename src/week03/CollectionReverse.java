package week03;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by georgipavlov on 02.12.15.
 */
public class CollectionReverse {
    static <T> void  reverse (Collection<T> collection){
        Collection<T> jediForce = new LinkedList<>();
        Iterator itr = collection.iterator();
        Object element;
        while(itr.hasNext()) {
            element = itr.next();
            jediForce.add((T) element);
            System.out.print(element + " ");
        }
        collection.clear();
        Iterator itr2 = jediForce.iterator();

        while(itr2.hasNext()) {
            element = itr.next();
            collection.add((T)element);
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {

    }

}
