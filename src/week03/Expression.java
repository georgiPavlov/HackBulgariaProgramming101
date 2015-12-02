package week03;

import java.util.Stack;

/**
 * Created by georgipavlov on 02.12.15.
 */
public class Expression {
    static String line =  "()()()(";
    public  static boolean makeE(){
        Stack one = new Stack();
        for (int i = 0; i <line.length() ; i++) {
            if(line.charAt(i) == '('){
                one.push(line.charAt(i));
            }else if(line.charAt(i) == ')'){
                if(one.isEmpty()){
                    System.out.println("This is invalid to many ) !");
                    return false;
                }else{
                    one.pop();
                }
            }
        }
        if(one.isEmpty()){
            System.out.println("Everything ok");
            return true;
        }else {
            System.out.println("This is invalid to many ( !");
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(Expression.makeE());
    }
}
