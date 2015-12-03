package week02;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class NthLucas {
    static int nthLucas(int n){
        if(n == 0 ){
            return 1;
        }else if(n ==1){
            return 2;
        }
        int newL =0;
        int count =2;
        while(count != n){
          newL = count-1 + count-2;
            count++;
        }
        return newL;
    }

    public static void main(String[] args) {

        System.out.println( NthLucas.nthLucas(6));

    }
}
