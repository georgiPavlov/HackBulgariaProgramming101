package week01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class CanBalance {
    static boolean canBalance(int[] numbers) {
        int c;
        int size = numbers.length;
        if (size % 2 == 0) {
            c = 0;
        } else {
            c = 1;
        }
        Map<Integer, Integer> a = new HashMap<>();
        for (short k = 0; k < numbers.length; k++) {

            Integer count = a.get(numbers[k]);
            if (count == null) {
                count = 0;
            }
            a.put(numbers[k], count + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> mapE : a.entrySet()) {
            if (mapE.getValue() % 2 != 0) {
                count++;
            }
        }
        if (count > c) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(CanBalance.canBalance(new int[]{4, 2, 2, 4, 5}));
        System.out.println(CanBalance.canBalance(new int[]{4,1,2,1}));
    }
}
