package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class HasAnagramOf {
    static boolean hasAnagramOf(String A,String B){
        int count=0;

        char[] a=A.toCharArray();
        char[] b=B.toCharArray();

        for (int i = 0; i <A.length() ; i++) {
            for (int j = 0; j <b.length ; j++) {
                if(a[i] == b[j]){
                    b[j]='1';
                    count++;
                }
            }
        }

        if (count == A.length()){
            return true;
        }
        return false;

    }


    public static void main(String[] args) {
        System.out.println(HasAnagramOf.hasAnagramOf("abc","bac"));
    }
}
