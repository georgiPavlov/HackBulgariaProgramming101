package week02.StackImpl;

/**
 * Created by georgipavlov on 26.11.15.
 */
public class Test {
    public static void main(String[] args) {
        StackInterface one  =new StackImpl();
        one.push("one");
        one.push("two");
        System.out.println(one.pop());
        one.push("tree");
        one.push("tree");
        System.out.println(one.isEmpty());
        System.out.println(one.length());
        one.clear();
        System.out.println(one.isEmpty());
    }
}
