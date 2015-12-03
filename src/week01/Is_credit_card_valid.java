package week01;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class Is_credit_card_valid {
    public boolean is_credit_card_valid(String number){
        if(number.length() % 2 == 0 || !march(number)){
            System.out.println("string length is not odd or" +
                    " it contains not only numbers");
            return false;
        }
        long sum=0;
        BigInteger bigFac = BigInteger.valueOf(0);
        for (int i = 0; i < number.length() ; i++) {
            if(i % 2 != 0){
                bigFac.add(BigInteger.valueOf(Integer.parseInt(String.valueOf(number.charAt(i)))));
            }else {
                bigFac.add(BigInteger.valueOf(Integer.parseInt(String.valueOf(number.charAt(i)))));
            }
        }
        if(bigFac.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1){
            int res = Integer.parseInt(bigFac.toString());
            if(res % 10 == 0){
                return true;
            }
        }else {
            System.out.println("Too big value");
        }
        return false;
    }

    public boolean march(String number){
        final String USERNAME_PATTERN = "^[0-9]$";
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(number);

        return matcher.matches();

    }
    private Pattern pattern;
    private Matcher matcher;
}
