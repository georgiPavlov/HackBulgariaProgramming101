package week07.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Created by georgipavlov on 11.01.16.
 */
public class WordCountResult {
    int wordCount = 0;
    int linesCount =0;
    int charactersCount=0;


        public WordCountResult wordCount(File file) throws FileNotFoundException {
            Scanner scanner = new Scanner(file);
            this.wordCount = wordCountResut(file);
            this.linesCount = lineCount(file);
            this.charactersCount = charCount(file);
            scanner.close();
            return this;
        }


    public int wordCountResut(File file) throws FileNotFoundException {
        int count=0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            scanner.next();
            count++;
        }
       
        return count;
    }

    public int lineCount(File file) throws FileNotFoundException {
        int count=0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            scanner.nextLine();
            count++;
        }
        return count;
    }

    public int charCount(File file) throws FileNotFoundException {
        int count=0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            count+=scanner.nextLine().length();
        }
        return count;
    }



       public WordCountResult wordCount(Path p) throws FileNotFoundException {
           return wordCount(p.toFile());
       }







}
