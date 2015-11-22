package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class GetAverage {
    int getAverage(int[] arr) {
        long n = 0;
        for (int i = 0; i < arr.length; i++) {
            n += arr[i];

        }
        int nn= (int) n;
        return nn / arr.length;
    }
}
