package week03.Friday.Student;

/**
 * Created by georgipavlov on 04.12.15.
 */
public class Student {
     private int grade;
     private String name;

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public Student(int grade, String name) {

        this.grade = grade;
        this.name = name;
    }
}
