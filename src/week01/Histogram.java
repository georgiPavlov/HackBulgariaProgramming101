package week01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class Histogram {
    int[] histogram(short[][] image) {

        Map<Short, Integer> map = new HashMap<>();
        int[] result = new int[255];

        for (short j = 0; j < image[0].length; j++) {
            for (short k = 0; k < image.length; k++) {
                if(image[j][k] >= 0){
                    Integer count = map.get(image[j][k]);
                    if (count == null) {
                        count = 0;
                    }
                    map.put(image[j][k], count + 1);
                }else{
                    System.out.println("only + numbers!");
                    int[] arrErr = new int[0];
                    return arrErr;
                }

            }
        }
        for (Map.Entry<Short, Integer> mapE : map.entrySet()) {
            result[mapE.getKey()] = mapE.getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        Histogram histogram = new Histogram();
       short[][] shorts =  new short[][]{
               { 0, 0, 0, 0, 0 },
               { 3, 3, 0, 3, 0},
               { 0, 0, 5, 3, 0},
               { 0, 0, 43, 3, 0},
               { 0, 0, 4, 3, 0}
       };
        int[] arr =histogram.histogram(shorts);
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]!= 0)
            System.out.println("i = "+ i + " " + arr[i]);
        }

    }

}
