package week01;

import java.util.Stack;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class IsHack {
    public boolean isHack(int n){
        n = Math.abs(n);
        Stack<Integer> stack = new Stack<>();
        int temp;
        while(n != 0 ){
            temp = n % 2;
            stack.add(temp);
        }
        String string;
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            b.append(stack.pop());
        }
        string = b.toString();
        int count=0;
        if(string.length() % 2 != 0){
            for (int i = 0; i < string.length(); i++) {
                if(string.charAt(0) == 1){
                    count++;
                }
            }
            if(count % 2 != 0 && isPalindrome(string)){
                return true;

            }
        }
        return false;

    }

    boolean isPalindrome(String argument) {

        int size = argument.length();
        int frond = 0;
        int back = size;


        while (frond <= back) {
            char start = argument.charAt(frond);
            char end = argument.charAt(back);

            if (!(start == end)) {
                return false;
            }
            frond++;
            back--;


        }
        return true;
    }



    public void nextHack(int n){
        if(isHack(n)){
            n++;
            while (!isHack(n)) {
                if(n == Integer.MAX_VALUE){
                    System.out.println("no next hack number");
                    return;
                }
                n++;
            }
            System.out.print("Next number: " + n);
        }
    }
}
