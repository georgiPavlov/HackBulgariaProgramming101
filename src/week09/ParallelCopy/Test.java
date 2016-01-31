package week09.ParallelCopy;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        traverseDir("/home/georgipavlov/HackBulgariaProgramming101/src/week09");
    }
}
