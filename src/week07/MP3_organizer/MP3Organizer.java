package week07.MP3_organizer;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.filename.FilenameTag;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by georgipavlov on 13.01.16.
 */
public class MP3Organizer {

    static MP3File m;
    public static final String CONSTANT="/home/georgipavlov/HackBulgariaProgramming101/songs";


    public String getTags(String p) throws IOException, TagException {
        m = new MP3File(p);
        String artist = m.getID3v1Tag().getArtist();
        String album = m.getID3v1Tag().getAlbum();
        String linkArtist = CONSTANT + "/" + artist;
        String linkAlbum = linkArtist + "/" + album;
        if(!(new File(linkArtist).exists())){
            new File(linkAlbum).mkdirs();
        }
        if(!(new File(linkAlbum).exists())) {
            new File(linkAlbum).mkdirs();
        }
        Files.copy(Paths.get(p), Paths.get(linkAlbum), StandardCopyOption.REPLACE_EXISTING);
        return linkAlbum;
    }


    public void search(Path path) throws IOException, TagException {
        File directory = path.toFile();
        if(!directory.isDirectory()){
            if(viewIfItisMP3(directory)){
                 getTags(directory.getAbsolutePath());
            }
            return;
        }
        String[] directoryList = directory.list();
        for (int i = 0; i <directoryList.length ; i++) {
            File file = new File(directory.getAbsolutePath() + "/" + directoryList[i]);
            if(file.isDirectory()){
                search(file.toPath());
            }
            if(viewIfItisMP3(file)){
              getTags(file.getAbsolutePath());
            }
        }
    }

    public boolean viewIfItisMP3(File file){
        String[] directory = file.getAbsolutePath().split("[//]+");
        if(directory[directory.length-1].length() < 5){
            return false;
        }
        String substr = directory[directory.length-1].
                substring(directory[directory.length-1].length() - 3);
        if(!substr.equals("mp3")){
            return false;
        }
        return true;
    }

    public static void doWork() throws IOException, TagException {
        m = new MP3File("/home/georgipavlov/HackBulgariaProgramming101/08 - Hero.mp3");
        m.getFilenameTag().toString();
        FilenameTag tag = m.getFilenameTag();
       // System.out.print(tag.toString());
       // System.out.print(m.getID3v2Tag().toString());
        System.out.println(m.getID3v1Tag().getAlbumTitle());
        System.out.println(m.getID3v1Tag().getAlbum());
        System.out.println(m.getID3v1Tag().getArtist());

    }


    public static void main(String[] args) {
        try {
            doWork();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        }
    }

}
