package week01;

import java.math.BigInteger;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class Pow {
    int pow(int a, int b) {

        if (b == 0) return 1;
        int temp = pow(a, b / 2);
        BigInteger big = BigInteger.valueOf(temp);
        if (b % 2 == 0) {
            if(big.multiply(BigInteger.valueOf(temp)).compareTo
                    (BigInteger.valueOf(Integer.MAX_VALUE)) == 1){
                System.out.println("too big number");
                return 0;
            }
            return temp * temp;
        } else {
            return (a * temp * temp);
        }
    }
}
