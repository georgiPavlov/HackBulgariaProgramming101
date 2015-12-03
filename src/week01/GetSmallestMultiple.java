package week01;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class GetSmallestMultiple {
     static  long getSmallestMultiple(int upperBound) {

        upperBound = Math.abs(upperBound);
        long n = upperBound;
        p:
        for (int i = 1; i < upperBound; i++) {
            for (int j = 0; j < upperBound; j++) {
                if (j % i == 0 && n > i) {
                    n = i;
                } else if (j % i != 0) {
                    continue p;
                }
            }

        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(GetSmallestMultiple.getSmallestMultiple(3));
    }
}
