package week03;

import java.util.*;

/**
 * Created by georgipavlov on 03.12.15.
 */
public class CountOccurencesOfWords {

    Comparator<String> caseInsensitiveComparator =
            new Comparator<String>(){
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareToIgnoreCase(o2);
                }
            };

    private String[] a;
    public Map<String,Integer> yourSecondUtilMethod(String text){
        Map<String,Integer>  map = new TreeMap<>(caseInsensitiveComparator);
        Integer count;
        a=text.split("[ ]+");
        for(String e:a){
            count = map.get(e);
            if(count == null){
                count = 0;
            }
            count++;
            map.put(e,count);
        }
        return map;
    }

    public String yourFirstUtilMethod(Map<String,Integer> mapE){
        long startTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        builder.append("{");



        //This implementation takes more time!!!!!
        //List<String > list = Arrays.asList(a);
        //Set<String> set = new TreeSet<>(list);
        //Iterator<String> et = set.iterator();

        /*int count;
        String res;
        while(et.hasNext()){
            res = et.next();
            builder.append(res);
            builder.append(":");
            count = mapE.get(res);
            builder.append(count);
            builder.append(", ");
        }*/

         int count;
        for (int i = 0; i < a.length; i++) {
            if(builder.toString().contains(a[i])){
                continue;
            }
            builder.append(a[i]);
            builder.append(":");
            count = mapE.get(a[i]);
            builder.append(count);
            builder.append(", ");
        }
        builder.append("}");
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        return builder.toString();
    }

    public static void main(String[] args) {
        CountOccurencesOfWords countOccurencesOfWords = new CountOccurencesOfWords();
        Map<String,Integer> res= countOccurencesOfWords.
                yourSecondUtilMethod("Ninjas are all over the place! We are all going to die!");
        System.out.println(countOccurencesOfWords.yourFirstUtilMethod(res));
    }
}
