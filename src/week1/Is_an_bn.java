package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class Is_an_bn {
    public boolean is_an_bn(String word){

        if(word.length() % 2 != 0 ){
            return false;
        }
        int n = word.length() / 2;
        for (int i = 0; i < n ; i++) {
            if(word.charAt(i) != 'a'){
                return false;
            }
        }

        for (int i = n ; i < word.length() ; i++) {
            if(word.charAt(i) != 'b'){
                return false;
            }
        }


        return true;

    }
}
