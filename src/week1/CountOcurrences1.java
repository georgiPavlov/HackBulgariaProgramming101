package week1;
import static org.apache.commons.lang.StringUtils.countMatches;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class CountOcurrences1 {
    static int countOcurrences1(String needle, String haystack){
        int k=0;
        long count =0;
        while(true){
            k=haystack.indexOf(needle,k);
            if(k != -1){
                if(count >= Integer.MAX_VALUE){
                    System.out.println("to many Ocurrences");
                    return 0;
                }
                count++;
                k += needle.length();
            }else {
                break;
            }
        }
        return (int)count;
    }

    static int  countOcurrences(String needle, String haystack){
        return countMatches(needle, haystack);
    }

    public static void main(String[] args) {
        System.out.println(CountOcurrences1.countOcurrences1("abs","I have six pack abs "));
    }
}
