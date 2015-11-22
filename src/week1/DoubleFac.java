package week1;

import java.math.BigInteger;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class DoubleFac {
    long doubleFac(int n) {
        long fac = 0;
        BigInteger bigFac = BigInteger.valueOf(1);
        for (int i = 0; i <= n; i++) {
            bigFac.multiply(BigInteger.valueOf(i));
            if (bigFac.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1 ||
                    bigFac.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) == -1) {
                System.out.println("To big value");
                return 0;
            }
            fac *= i;

        }

        bigFac = BigInteger.valueOf(1);
        for (int i = 0; i <= n; i++) {
            bigFac.multiply(BigInteger.valueOf(i));
            if(bigFac.compareTo(BigInteger.valueOf(Long.MAX_VALUE))==1 ||
                    bigFac.compareTo(BigInteger.valueOf(Long.MIN_VALUE))==-1){
                System.out.println("To big value");
                return 0;
            }
            fac *= i;
        }

        return fac;
    }
}
