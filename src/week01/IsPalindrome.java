package week01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class IsPalindrome {
    private Matcher matcher2;
    private Pattern pattern2;
    public boolean march2(String number){
        final String USERNAME_PATTERN = "^[0-9]$";
        pattern2 = Pattern.compile(USERNAME_PATTERN);
        matcher2 = pattern2.matcher(number);

        return matcher2.matches();

    }
    boolean isPalindrome(String argument) {
        if(!march2(argument)){
            System.out.println("argument error");
            return false;
        }
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

    boolean isPalindrome(int argument) {
        String temp = Integer.toString(Math.abs(argument));
        if (isPalindrome(temp)) {
            return true;
        }
        return false;
    }

}
