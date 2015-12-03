package week01;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class Anagram {
    static boolean  anagram(String A, String B){

        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        if(A.length() != B.length()){
            return false;
        }
        for (int i = 0; i <A.length() ; i++) {
            for (int j = 0; j <b.length ; j++) {
                if(a[i] == b[j]){
                    b[j]='1';
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            if(b[i] != '1'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Anagram.anagram("fffaa" , "aafff"));
        System.out.println(Anagram.anagram("fffaa" , "aaff"));
    }
}
