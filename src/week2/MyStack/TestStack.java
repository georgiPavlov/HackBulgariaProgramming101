package week2.MyStack;

/**
 * Created by georgipavlov on 27.11.15.
 */
public class TestStack {
    public static void main(String[] args) {
        FactotyStack f=new FactotyStack();
        f.push(4);
        System.out.println(f.pop());
        System.out.println(f.isEmpty());
    }
}
