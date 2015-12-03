package week01;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class SumOfNumbers {
    int sumOfNumbers(String input){
        String[] arr = input.split("[^0-9]+");
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i].charAt(0) != ' ') {
                sum += Integer.parseInt(arr[i]);
            }
        }
        return sum;
    }
}
