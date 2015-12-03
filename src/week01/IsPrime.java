package week01;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class IsPrime {
    boolean isPrime(int n) {
        n=Math.abs(n);
        if (n % 2 == 0) return false;
        for (int i = 3; i * i < n; i += 2)
            if (n % i == 0) return false;
        return true;
    }
}
