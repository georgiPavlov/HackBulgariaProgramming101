package week2.FastAndFurious;

/**
 * Created by georgipavlov on 25.1 1.15.
 */
public class Volkswagen extends Car implements German  {
    boolean isEcoFriendly(boolean testing){
        if(testing){return true;}
        return false;
    }

}
