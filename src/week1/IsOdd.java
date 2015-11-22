package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class IsOdd {
    boolean isOdd(int n) {
        n=Math.abs(n);
        int odd = n % 2;
        if (odd == 0) {
            return false;
        }
        return true;
    }
}
