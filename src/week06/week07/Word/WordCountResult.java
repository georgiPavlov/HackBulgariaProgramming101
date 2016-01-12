package week06.week07.Word;

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
            while (scanner.hasNextLine()){
                charactersCount += scanner.nextLine().length();
                linesCount++;
            }
            while (scanner.hasNext()){
                wordCount++;
            }
            return this;
        }

       public WordCountResult wordCount(Path p) throws FileNotFoundException {
           return wordCount(p.toFile());
       }







}
