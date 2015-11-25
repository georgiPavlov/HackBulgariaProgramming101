package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class GetLargestPalindrome {
    static  long getLargestPalindrome(long N) {
        if(N==0){
            return 0;
        }
        N = Math.abs(N);
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

    static boolean itIsPalindrome(long i) {
        i= Math.abs(i);
        String num = Long.toString(i);
        int size = num.length();
        int frond = 0;
        int back = size-1;


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

    public static void main(String[] args) {
        System.out.println(GetLargestPalindrome.getLargestPalindrome(100));
    }
}
