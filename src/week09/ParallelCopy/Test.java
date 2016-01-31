package week09.ParallelCopy;

import java.io.File;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class Test {
    public static void main(String[] args) {
        File f = new File("/home/georgipavlov/HackBulgariaProgramming101/im.jpg");
        System.out.println((double) f.length()/1024/1024);
    }
}
