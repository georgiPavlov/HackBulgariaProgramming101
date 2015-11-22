package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class GetSmallestMultiple {
    long getSmallestMultiple(int upperBound) {

        if(upperBound<0){
            System.out.println("Need to be positive");
            return -1;
        }
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
}
