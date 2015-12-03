package week01;

import java.math.BigInteger;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class Zero_insert {
    public static int zero_insert(int n){
        boolean minus=false;
        if(n<0){
            n = Math.abs(n);
            minus = true;
        }
        String num = Integer.toString(n);
        StringBuilder b= new StringBuilder();
        int j=0;
        for (int i = 1; i <num.length() ; i++) {
            if(b.length() == 0){
                b.append(num.charAt(j));
            }
            if(num.charAt(i) == num.charAt(j)){
                b.append('0');
            }else if( (Integer.parseInt(String.valueOf(num.charAt(i))) +
                    Integer.parseInt(String.valueOf(num.charAt(j))))% 10 == 0){
                b.append('0');
            }
            b.append(num.charAt(i));
            j++;

        }
        BigInteger big = BigInteger.valueOf(Integer.MAX_VALUE);
        if(big.compareTo(new BigInteger( b.toString() )) == -1){
            System.out.println("too big number for integer");
            return 0;
        }
        String res =null;
        if(minus){
            res = "-";
        }else {
            res="";
        }
        res += b.toString();
        n= Integer.parseInt(res);
        return n;
    }
}
