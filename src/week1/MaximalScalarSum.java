package week1;

import java.math.BigInteger;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class MaximalScalarSum {
    long maximalScalarSum(int[] a, int[] b){
        int c=0;
        int n=a.length;
        int swap=0;
        int d=0;

        for (c = 0; c < ( n - 1 ); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (a[d] > a[d+1]) /* For descending order use < */
                {
                    swap       = a[d];
                    a[d]   =   a[d+1];
                    a[d+1] =   swap;
                }
            }
        }


        n=b.length;
        swap=0;
        d=0;


        for (c = 0; c < ( n - 1 ); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (a[d] > a[d+1]) /* For descending order use < */
                {
                    swap       = a[d];
                    a[d]   =   a[d+1];
                    a[d+1] =   swap;
                }
            }
        }

        long sum=0;
        BigInteger bigInteger1 = BigInteger.valueOf(0);
        BigInteger bigInteger2 = BigInteger.valueOf(1);
        for (int i = 0; i <a.length ; i++) {
            bigInteger2.multiply(BigInteger.valueOf(a[i]));
            bigInteger2.multiply(BigInteger.valueOf(b[i]));
            if(bigInteger2.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1){
                System.out.println("to big value");
                return 0;
            }
            if(bigInteger1.add(bigInteger2).compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1){
                System.out.println("to big value");
                return 0;
            }
            bigInteger2 = BigInteger.valueOf(1);
            sum +=a[i]*b[i];
        }
        return sum;

    }
}
