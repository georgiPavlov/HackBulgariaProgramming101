package week08;

import java.util.*;
/**
 * Created by georgipavlov on 18.01.16.
 */
public class PeerReview {
    private static Random rand;
    private Map<Integer,String> names;

    public void print2People(Map<Integer,String> namesForDo){
        rand = new Random();
        int  n;
        names = namesForDo;
        int cap = names.size();
        if(cap % 2 != 0){
            names.put(cap+1 , "Default");
        }
        int count = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < names.size() ; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < names.size(); i++){
            int  z  = numbers.get(i);
            System.out.println(names.get(z));
            count++;
            if(count %  2 == 0 && count != 0){
                System.out.println();
            }

        }
    }

    public void addPeople(){
        int count = 1;
        Map<Integer,String > map = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            map.put(count,Integer.toString(count));
            count++;
            //can be made with scanner or file TODO home
        }
        for (int i = 0; i < 1; i++) {
            print2People(map);
        }
    }

    public static void main(String[] args) {
        PeerReview  p = new PeerReview();
        p.addPeople();
    }

}
