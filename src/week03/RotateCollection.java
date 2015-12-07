package week03;

import java.util.*;

/**
 * Created by georgipavlov on 02.12.15.
 */
public class RotateCollection<T> {
     void rotate(Collection<T> collection, int rotateStep ){
        if(rotateStep<0 || rotateStep>collection.size()){
            if(rotateStep>collection.size()){
                rotateStep = rotateStep - collection.size();
            }else {
                System.out.println("cant make the operation");
                return;
            }

        }
         int temp = rotateStep;
         Stack<T> stack = new Stack<>();
        Queue<T> queue = new LinkedList<>();

        Iterator<T> et = collection.iterator();
        while (et.hasNext() ){
            stack.push(et.next());
        }
        while (rotateStep > 0 ){
            queue.add(stack.pop());
            rotateStep--;
        }
         Iterator<T> et2 = collection.iterator();
        for (int i = 0; i < collection.size()-temp; i++) {
            queue.add(et2.next());
        }
        collection.clear();
        collection.addAll(queue);
         Iterator<T> et3 = collection.iterator();
         while (et3.hasNext() ){
             System.out.println(et3.next());
         }


    }

    public static void main(String[] args) {
        RotateCollection<Integer> v= new RotateCollection<>();
        ArrayList<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        v.rotate(a, 2 );


    }


}
