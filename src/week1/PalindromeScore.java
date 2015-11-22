package week1;

import java.math.BigInteger;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class PalindromeScore {

    private  int count;
    private boolean palTrue=true;

    public int PalindromeScore(int n){
        if(isPalindrome(n) && palTrue){
            return 1;
        }else if(!palTrue){
            System.out.println("palindrome not found ");
            return 0;
        } else {
            int func=pScore(n);
            return PalindromeScore(func);
        }
    }


    public int pScore(int n){
        int func;
        String string = Integer.toString(n);
        StringBuilder b =new StringBuilder(string);
        string=b.reverse().toString();
        BigInteger bigInteger = BigInteger.valueOf(n);
        bigInteger.add(BigInteger.valueOf(Integer.parseInt(string)));
        bigInteger.add(BigInteger.valueOf(1));
        if(bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) == -1){
            func = Integer.parseInt(bigInteger.toString());
            return func;
        }
        palTrue=false;
        return 0;
    }

    public  boolean isPalindrome(int n){
        n= Math.abs(n);
        String argument= Integer.toString(n);
        int size = argument.length();
        int frond = 0;
        int back = size;

        while (frond <= back) {
            char start = argument.charAt(frond);
            char end = argument.charAt(back);

            if (!(start == end)) {
                return false;
            }
            frond++;
            back--;
        }
        return true;
    }
}
