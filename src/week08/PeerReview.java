package week08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Created by georgipavlov on 18.01.16.
 */
public class PeerReview {
    private Map<Integer,String> names;
    Scanner scanner;

    public PeerReview(){
        scanner = new Scanner(System.in);
    }

    public void print2People(Map<Integer,String> namesForDo){
        this.names = namesForDo;
        int cap = names.size();
        if(cap % 2 != 0){
            names.put(cap+1 , "Default");
            cap++;
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers = (ArrayList<Integer>) snuffle(numbers);

        for (int i = 0; i < names.size(); i++){
            int  z  = numbers.get(i);
            System.out.println(names.get(z));

            if(i %  2 != 0){
                System.out.println();
            }
        }
    }

    public List<Integer> snuffle(List<Integer> numbers){
        for (int i = 0; i < names.size() ; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public void addPeopleWithScanner(int loops){
        int count = 1;
        scanner = new Scanner(System.in);
        Map<Integer,String > map = new HashMap<>();
        String result;
        while (true) {
            result = scanner.nextLine();
            if(result != null){
            map.put(count,result);
            count++;
            }else {
                break;
            }
        }
        loopTimes(map,loops);

    }

    public void addPeopleFromTextFile(int loops,String name) throws FileNotFoundException {
        scanner = new Scanner(new File(name));
        String result;
        Map<Integer,String > map = new HashMap<>();

        for (int count = 1;scanner.hasNextLine();count++){
            result = scanner.nextLine();
            map.put(count,result);
            count++;
        }
        loopTimes(map,loops);
        scanner.close();
    }

    public void loopTimes(Map<Integer,String> map,int loops){
        for (int i = 0; i < loops; i++) {
            print2People(map);
            System.out.println("----------- loop:" + loops + " -----------" );
        }
    }

    public void menu(int loops) throws FileNotFoundException {
        System.out.println("Enter 1 for console or 2 for text file");
        int n = scanner.nextInt();
        switch (n){
            case 1:{
                addPeopleWithScanner(loops);
                break;
            }case 2:{
                System.out.println("Enter directory of the file");
                scanner = new Scanner(System.in);
                String fileName = scanner.nextLine();
                addPeopleFromTextFile(loops,fileName);
                break;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        PeerReview  p = new PeerReview();
        p.menu(5);
    }
}
