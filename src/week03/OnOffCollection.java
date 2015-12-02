package week03;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by georgipavlov on 02.12.15.
 */
public class OnOffCollection {
    static <T> void  NoSecondElement(Collection<T> collection){

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
        collection.clear();

        for(HashMap.Entry<T,Integer> mapE: map.entrySet()){
            if(2 < mapE.getValue()){
               T el = mapE.getKey();
                collection.add(el);
            }
        }
    }

}
