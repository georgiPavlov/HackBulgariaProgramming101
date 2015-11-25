package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class GetOddOccurrence {
    static int getOddOccurrence(int... array) {

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(GetOddOccurrence.getOddOccurrence(1,1,2,2,3,3,5,5,5));
    }
}
