package week06.UserInputChecker;

/**
 * Created by georgipavlov on 06.01.16.
 */
public class UserInputReciever {
    public boolean order(int i,String z){
        boolean t=false;
        switch (i){
            case 1:{
               t = new PersonNameValidator().PersonNameValidator1(z);
            }
            //case 2,3,4........
        }
        return t;
    }
}
