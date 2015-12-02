package week03;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by georgipavlov on 02.12.15.
 */
public class DuplicateValues {
    static <T> T  DuplicateValues(Collection<T> collection){
        HashMap<T,Integer> map = new HashMap<>();
        Integer count;
        for(T e:collection){
            count = map.get(e);
            if(count == null){
                count = 0;
            }
            count++;
            map.put(e,count);
        }
        T el=null;
        for(HashMap.Entry<T,Integer> mapE: map.entrySet()){
            if(1 == mapE.getValue()){
                 el = mapE.getKey();
            }
        }
        return el;
    }

    public static void main(String[] args) {

    }

}
