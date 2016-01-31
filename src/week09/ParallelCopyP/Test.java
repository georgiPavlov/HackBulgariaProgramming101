package week09.ParallelCopyP;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class Test {
    public static void traverseDir(String startDirectory) {
        Queue<File> visitedDirsQueue = new LinkedList<File>();
        visitedDirsQueue.add(new File(startDirectory));
        while (visitedDirsQueue.size() > 0) {
            File currentDir = visitedDirsQueue.remove();
            System.out.println(currentDir.getAbsolutePath());
            File[] children = currentDir.listFiles();
            if (children != null) {
                for (File child : children) {
                    if (child.isDirectory()) {
                        visitedDirsQueue.add(child);
                    }
                    System.out.println(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        String p ="/home/georgipavlov/HackBulgariaProgramming101/src/week09";
        String z = "/home/georgipavlov";
        System.out.println(p.substring(z.length(),p.length()));

    }
}
