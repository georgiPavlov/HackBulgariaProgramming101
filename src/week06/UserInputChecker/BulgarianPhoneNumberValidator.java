package week06.UserInputChecker;

/**
 * Created by georgipavlov on 06.01.16.
 */
public class BulgarianPhoneNumberValidator {
    private static final String NAME = "Jonny";
    boolean result;
    UserInputChecker.Validator t;

    public boolean PersonNameValidator1(String i){
        t = new UserInputChecker.Validator() {
            @Override
            public boolean validate(String input) {
                if(input.equals(NAME)){
                    return true;
                }
                return false;
            }
        };
        return t.validate(i);
    }
}
