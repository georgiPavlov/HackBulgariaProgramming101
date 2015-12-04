package week03.Friday.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by georgipavlov on 04.12.15.
 */
public class Sort {

     List<Student> sortList(List<Student> students){
        Set map = new TreeSet<>(SortComparator);
        map.addAll(students);
        students.clear();
        students.addAll(map);
        return students;
    }

    Comparator<Student> SortComparator =
            new Comparator<Student>(){
                @Override
                public int compare(Student o1, Student o2) {
                    if(o1.getGrade() > o2.getGrade()){
                        return -1;
                    }else if(o1.getGrade() < o2.getGrade()){
                        return 1;
                    }else{
                        int a = (int)o1.getName().charAt(0);
                        int b = (int)o2.getName().charAt(0);
                        if(a<b){
                            return -1;
                        }else {
                            return 1;
                        }
                    }
                }
            };
}
