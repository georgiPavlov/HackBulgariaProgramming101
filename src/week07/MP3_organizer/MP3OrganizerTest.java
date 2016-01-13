package week07.MP3_organizer;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created by georgipavlov on 13.01.16.
 */
public class MP3OrganizerTest {
    @Test
    public void test_if_it_is_mp3_file() throws Exception {
        MP3Organizer mp3Organizer = new MP3Organizer();
        File file = new File("/home/georgipavlov/HackBulgariaProgramming101/08 - Hero.mp3");
        assertEquals(true,mp3Organizer.viewIfItisMP3(file));
    }



}