package week14;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgipavlov on 10.03.16.
 */
public class Java8Test {
    static class Inner{
       public int numberIn;
       public String nameIn;
       public int age;



        public Inner(int numberIn, String nameIn, int age) {

            this.numberIn = numberIn;
            this.nameIn = nameIn;
            this.age = age;
        }
    }


    public static void doSome(){
        /* (int i = 0; i < 5; i++) {
            Func_Interface a = () ->  {
                int k;
                System.out.println("This will work ");
                System.out.println("some more work");
                 return k=5;

            };
            int r = a.doWork();
            System.out.println(r);
            a.doWork();
        }*/


        List<Inner> persons = new ArrayList<>();
        persons.add(new Inner(2312321,"Gosho" , 10));
        persons.add(new Inner(2312321,"Gosho" , 10));
        persons.add(new Inner(2312321,"Gosho" , 17));
        persons.add(new Inner(2312321,"Gosh" , 10));
        persons.add(new Inner(2312321,"Gosh" , 90));
        persons.add(new Inner(2312321,"Gosho" , 10));
        persons.add(new Inner(2312321,"Gosho" , 10));
        persons.add(new Inner(2312321,"Gosho" , 10));



        persons.stream()
                .filter(p -> p.nameIn.equals("Gosho"))
                //.map(inner1 -> inner1.age)
                .forEach(s -> System.out.println(s.age + " " + s.nameIn));


    }

    public static void main(String[] args) {
        doSome();
    }
}
