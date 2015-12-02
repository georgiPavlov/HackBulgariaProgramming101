package week03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by georgipavlov on 02.12.15.
 */
public class GenericPalindrome<T> {
    private Matcher matcher2;
    private Pattern pattern2;
    public boolean march2(String number){
        final String USERNAME_PATTERN = "^[0-9]$";
        pattern2 = Pattern.compile(USERNAME_PATTERN);
        matcher2 = pattern2.matcher(number);

        return matcher2.matches();

    }
    boolean isPalindrome(T argument) {
        if(!march2((String)argument)){
            System.out.println("argument error");
            return false;
        }
        String arg = (String)argument;
        int size = arg.length();
        int frond = 0;
        int back = size;


        while (frond <= back) {
            char start = arg.charAt(frond);
            char end = arg.charAt(back);

            if (!(start == end)) {
                return false;
            }
            frond++;
            back--;


        }
        return true;
    }


}
