package week07;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by georgipavlov on 12.01.16.
 */
public class FindAllBrokenLinks {
    public static void find(Path path) throws IOException {
        File p = path.toFile();
        String[] a = p.list();

        String add = p.getAbsolutePath();
        for (int i = 0; i <a.length ; i++) {
            Path findPath = Paths.get(a[i]);
            if(Files.isSymbolicLink(findPath)){
                Path symbolicLink= Files.readSymbolicLink(path);
                File file = symbolicLink.toFile();
                if(!file.exists()){
                    System.out.println(symbolicLink.toString());
                }
            }
            File f = new File(add + "/" + a[i]);
            if(f.isDirectory()){
                find(Paths.get(add + "/" + a[i]));
            }
        }


    }

    public static void main(String[] args) {
        Path a = Paths.get("/home/georgipavlov/HackBulgariaProgramming101/src/week06/week07");
        try {
            find(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
