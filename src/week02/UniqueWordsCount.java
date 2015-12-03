package week02;

import java.util.HashSet;

/**
 * Created by georgipavlov on 24.11.15.
 */
public class UniqueWordsCount {
    public static int uniqueWordsCount(String[] arr){
        HashSet<String> set = new HashSet<>();
        int count=0;
        p:for (int i = 0; i <arr.length ; i++) {
            if(set.contains(arr[i])){
                continue p;
            }
            set.add(arr[i]);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(UniqueWordsCount.uniqueWordsCount(new String[] {"apple", "banana", "apple", "pie"}));
        System.out.println(UniqueWordsCount.uniqueWordsCount(new String[] {"java", "java", "java", "android"}));
        System.out.println(UniqueWordsCount.uniqueWordsCount(new String[] {"HELLO!", "HELLO!", "HELLO!","HELLO!"}));
    }
}
