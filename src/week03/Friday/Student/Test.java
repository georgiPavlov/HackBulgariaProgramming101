package week03.Friday.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgipavlov on 04.12.15.
 */
public class Test {
    public static void main(String[] args) {
        Student student1 = new Student(5,"Mixail");
        Student student2 = new Student(4,"Petar");
        Student student3 = new Student(3,"Petar");
        Student student4 = new Student(6,"Gosho");
        Student student5 = new Student(3,"Angel");
        List<Student> one =new ArrayList<>();
        one.add(student1);
        one.add(student2);
        one.add(student3);
        one.add(student4);
        one.add(student5);
        Sort sort = new Sort();
        List<Student> two;
         two  =sort.sortList(one);
        for (int i = 0; i <two.size() ; i++) {
            System.out.println(  two.get(i).getGrade() + " " +  two.get(i).getName() );
        }




    }
}
