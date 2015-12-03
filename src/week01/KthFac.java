package week01;

import java.math.BigInteger;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class KthFac {

    long kthFac(int k, int n){
        long res=0;
        BigInteger bigInteger = BigInteger.valueOf(1);
        for (long i = 1; i < n; i++) {
            bigInteger.multiply(BigInteger.valueOf(i));
            if(bigInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1){
                System.out.println("Too big fac");
                return 0;
            }
            res*=i;
            k--;
            if(k == 0){
                break;
            }
        }
        return res;
    }
}
