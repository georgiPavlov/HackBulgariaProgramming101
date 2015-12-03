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

}
