package week09;

import week09.ParallelMinimalPointCalculations.Anotation;

import java.lang.annotation.Annotation;

/**
 * Created by georgipavlov on 27.01.16.
 */@ClassInfo (
        author = "John Doe",
        currentRevision = 6,
        checked = false
)
public class ClassInfoMain {


    public static void main(String[] args) {
        ClassInfoMain m = new ClassInfoMain();
        Class<?> classInfo =  m.getClass();
        System.out.println(classInfo.getDeclaredAnnotations().toString());
        ClassInfo u = classInfo.getAnnotation(ClassInfo.class);
        Annotation[] a = classInfo.getDeclaredAnnotations();
        System.out.println(u.author());
        for (Annotation annotation : a) {
            ClassInfo p = (ClassInfo) annotation;
            System.out.println(p.author() +  " " + p.checked() + " " + p.currentRevision());
            System.out.println("ok");
        }

    }
}
