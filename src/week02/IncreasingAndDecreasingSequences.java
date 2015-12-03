package week02;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class IncreasingAndDecreasingSequences{
    static boolean IsIncreasing(int[] sequence){
        if(sequence.length == 1 && sequence[0] == 0 ){
            return false;
        }else if(sequence.length == 1){
            return  true;
        }
        int i=1;
        int j=0;
        for (; i <sequence.length; i++,j++) {
            if(sequence[i] < sequence[j]){
               return false;
            }

        }
        return true;
    }

    static boolean IsDecreasing(int[] sequence){
        if(sequence.length == 1 && sequence[0] == 0 ){
            return false;
        }else if(sequence.length == 1){
            return  true;
        }
        int i=1;
        int j=0;
        for (; i <sequence.length; i++,j++) {
            if(sequence[i] > sequence[j]){
                return false;
            }

        }
        return true;


    }

    public static void main(String[] args) {
        int[] a= {0};
        System.out.println(IncreasingAndDecreasingSequences.IsDecreasing(a));
        System.out.println(IncreasingAndDecreasingSequences.IsIncreasing(a));
    }









































}
