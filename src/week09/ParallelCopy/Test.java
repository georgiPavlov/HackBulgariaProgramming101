package week09.ParallelCopy;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class Test {
    public static void main(String[] args) {

        //System.out.println((double) f.length()/1024/1024);
        try {
            System.out.println(Files.list(Paths.get("/home/georgipavlov/HackBulgariaProgramming101")).count());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path dir = Paths.get("/home/georgipavlov/HackBulgariaProgramming101");
        int i = 1;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

            for (Path p : stream) {
                //larger than max files, exit
                System.out.println(p.toString());
                //if(p.id)

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
