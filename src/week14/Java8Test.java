package week14;

/**
 * Created by georgipavlov on 10.03.16.
 */
public class Java8Test {
    public static void doSome(){
        for (int i = 0; i < 5; i++) {
            Func_Interface a = () ->  {
                int k;
                System.out.println("This will work ");
                System.out.println("some more work");
                 return k=5;

            };
            int r = a.doWork();
            System.out.println(r);
        }
    }

    public static void main(String[] args) {
        doSome();
    }
}
