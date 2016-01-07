package week06.FunnyArraySorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by georgipavlov on 06.01.16.
 */
public class FunnyArraySorter {
    private Integer pivot;

    public FunnyArraySorter(Integer pivot) {
        this.pivot = pivot;
    }

    List<Integer> reverseSort(List<Integer> list){
        Collections.sort(list,new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(a<b){
                    return 1;
                }else if(a>b){
                    return -1;
                }
                return 0;
            }
        });
        return list;
    }

   List<Integer> pivotSubtractionSort(List<Integer> list){
       Collections.sort(list,new Comparator<Integer>() {
           @Override
           public int compare(Integer a, Integer b) {
               Integer c =a-pivot;
               if(c<b){
                   return 1;
               }else if(c>b){
                   return -1;
               }
               return 0;
           }
       });
       return list;
   }

    List<Integer> pivotDivisionSort(List<Integer> list){
        Collections.sort(list,new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                Integer c =a/pivot;
                if(c<b){
                    return 1;
                }else if(c>b){
                    return -1;
                }
                return 0;
            }
        });
        return list;
    }
}
