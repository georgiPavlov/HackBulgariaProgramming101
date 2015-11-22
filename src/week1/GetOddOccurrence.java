package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class GetOddOccurrence {
    int getOddOccurrence(int... array) {

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }
}
