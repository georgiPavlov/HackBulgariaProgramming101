package week01;

import java.math.BigInteger;

/**
 * Created by georgipavlov on 23.11.15.
 */
 public class DoubleFac {
    static long doubleFac(int n) {
        long nn;
        long fac = 1;
        BigInteger bigFac = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            bigFac.multiply(BigInteger.valueOf(i));
            if (bigFac.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1 ||
                    bigFac.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) == -1) {
                System.out.println("To big value");
                return 0;
            }
            fac *= i;

        }
        nn=fac;
        fac=1;
        bigFac = BigInteger.valueOf(1);
        for (int i = 1; i <= nn; i++) {
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

    public static void main(String[] args) {
        System.out.println(DoubleFac.doubleFac(3));
    }
}
