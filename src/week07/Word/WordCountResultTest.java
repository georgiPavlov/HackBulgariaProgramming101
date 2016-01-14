package week07.Word;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

/**
 * Created by georgipavlov on 14.01.16.
 */
public class WordCountResultTest {

    WordCountResult w;
    File file;

    @Before
    public void testCreate(){
        w=new WordCountResult();
         file = new File("/home/georgipavlov/HackBulgariaProgramming101/src/week07/Word/thisTestFile");
    }

    @Test()
    public void testWordCountResut() throws FileNotFoundException {
        int res =w.wordCountResut(file);
        System.out.println(res);
        assertEquals(4, res);


    }

    @Test() public void testLineCount() throws FileNotFoundException {
        int res =w.lineCount(file);
        assertEquals(2, res);

    }

    @Test()
    public void testCharCount() throws FileNotFoundException {
        int res =w.charCount(file);
        assertEquals(16, res);

    }
}