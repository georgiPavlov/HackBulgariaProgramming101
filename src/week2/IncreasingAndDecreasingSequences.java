package week2;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class IncreasingAndDecreasingSequences{
    boolean IsIncreasing(int[] sequence){
        if(sequence.length == 0 ){
            return false;
        }else if(sequence.length == 1){
            return  true;
        }
        int i=1;
        int j=0;
        for (; i <sequence.length; i++,j++) {
            if(i < j){
               return false;
            }

        }
        return true;
    }

    boolean IsDecreasing(int[] sequence){
        if(sequence.length == 0 ){
            return false;
        }else if(sequence.length == 1){
            return  true;
        }
        int i=1;
        int j=0;
        for (; i <sequence.length; i++,j++) {
            if(i > j){
                return false;
            }

        }
        return true;
    }









































}
