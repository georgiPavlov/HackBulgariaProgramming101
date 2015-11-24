package week1;

import java.math.BigInteger;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class GetAverage {
     static int getAverage(int[] arr) {
        long n = 0;
        for (int i = 0; i < arr.length; i++) {
            n += arr[i];

        }
        BigInteger a= BigInteger.valueOf(n);
        if(a.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) == 1 ||
                a.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) == -1){
            System.out.println("to big number for integer");
            return 0;
        }

        int nn= (int) n;
        return nn / arr.length;
    }

    public static void main(String[] args) {
        System.out.println(GetAverage.getAverage(new int[]{1,2,3}));
    }


}
