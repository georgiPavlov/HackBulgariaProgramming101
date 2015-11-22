package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class GetLargestPalindrome {
    long getLargestPalindrome(long N) {
        if(N==0){
            return 0;
        }
        if(N<0){
            System.out.println("Need to be positive");
            return -1;
        }
        long temp = 0;
        for (long i = 0; i < N; i++) {
            if (i < 9 && temp < i) {
                temp = i;
            } else if ((itIsPalindrome(i)) && temp < i) {
                temp = i;
            }
        }
        return temp;
    }

    boolean itIsPalindrome(long i) {
        i= Math.abs(i);
        String num = Long.toString(i);
        int size = num.length();
        int frond = 0;
        int back = size;


        while (frond <= back) {
            char start = num.charAt(frond);
            char end = num.charAt(back);

            if (!(start == end)) {
                return false;
            }
            frond++;
            back--;


        }
        return true;
    }
}
