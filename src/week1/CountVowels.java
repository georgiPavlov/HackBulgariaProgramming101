package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class CountVowels {


    public int  countVowels(String str){
        String line ="aeiouy";
        char[] charArray = str.toCharArray() ;
        int count=0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j <line.length() ; j++) {
                if(Character.isLetter(line.charAt(j))) {
                    if (Character.toLowerCase(charArray[i]) ==
                            Character.toLowerCase(line.charAt(j))) {
                        count++;
                    }
                }
            }
        }
        return count;

    }
}
