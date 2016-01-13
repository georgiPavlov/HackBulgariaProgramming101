package week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by georgipavlov on 12.01.16.
 */
public class FixTheseSubtitles {
    public static void fixEncoding(Path path) throws FileNotFoundException, UnsupportedEncodingException {
        File old =path.toFile();
        File newFile = new File("this.str");
        Scanner scanner = new Scanner(old,"Windows-1251");
        PrintStream p =  new PrintStream(newFile,"UTF-8");
        while (scanner.hasNextLine()){
            String t = scanner.nextLine();
            System.out.println(t);
            byte[] bytes = t.getBytes(StandardCharsets.UTF_8);
            String s = new String(bytes, Charset.forName("UTF-8"));
            p.print(s);
            p.print(System.lineSeparator());
        }
        old.delete();
        newFile.renameTo(path.toFile());
        scanner.close();
        p.close();
    }

    public static void main(String[] args) {
        Path p = Paths.get("/home/georgipavlov/HackBulgariaProgramming101/lost.s04e11.hdtv.xvid-2hd.srt");
        try {
            fixEncoding(p);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
