package week1;

import java.util.Hashtable;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class MaxSpan {
    int maxSpan(int[] numbers) {
        Hashtable<Integer, Integer> map = new Hashtable<>();
        int num;

        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            num = numbers[i];

            if (map.containsKey(num)) {
                int span = i - map.get(num) + 1;
                if (span > max) {
                    max = span;
                }
            } else {
                map.put(num, i);
            }
        }
        return max;
    }
}
