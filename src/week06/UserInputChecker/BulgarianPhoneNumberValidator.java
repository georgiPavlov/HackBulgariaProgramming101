package week06.UserInputChecker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by georgipavlov on 06.01.16.
 */
public class BulgarianPhoneNumberValidator {
    boolean result;
    UserInputChecker.Validator t;
    private Pattern pattern;
    private Matcher matcher;
    private static final String USERNAME_PATTERN = " ^(\\+359)+([0-9]{7,15})$";

    public boolean PersonNameValidator1(String i){
        t = new UserInputChecker.Validator() {
            @Override
            public boolean validate(String input) {
                pattern = Pattern.compile(USERNAME_PATTERN);
                final String inP = input;
                matcher = pattern.matcher(inP);
                return matcher.matches();
            }
        };
        return t.validate(i);
    }
}
