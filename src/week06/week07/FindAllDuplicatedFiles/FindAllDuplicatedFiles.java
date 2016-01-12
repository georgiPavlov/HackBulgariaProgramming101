package week06.week07.FindAllDuplicatedFiles;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by georgipavlov on 12.01.16.
 */
public class FindAllDuplicatedFiles {
    ArrayList<String> comparedFiles;


    public void doWork(Path path){
        comparedFiles = new ArrayList<>();
        File file = path.toFile();
        String[] files = file.list();
        for (int i = 0; i < files.length; i++) {
            String result= file.getAbsolutePath() + "/"+  files[i];
            File file2 = new File(result);
            if(file2.isFile() && file.length() < 512){
                for (int j = 0; j <comparedFiles.size() ; j++) {
                    if(!(compare(new File(comparedFiles.get(i)),file2))){
                        continue;
                    }
                }
                //recursion
                comparedFiles.add(file2.getAbsolutePath());

            } else if(file.isDirectory()){
            doWork(file2.toPath());
            }

        }
    }


    public void search(File fileSearch,File directory){
        String[] files = directory.list();
        for (int i = 0; i < files.length ; i++) {
            File file = new File(directory.getAbsolutePath() + "/" + files[i] );
            if(file.isFile() && file.length() < 512){
                compare(fileSearch,file);
            }else if(file.isDirectory()){
                search(fileSearch,file);
            }
            
        }
    }

    public boolean compare(File start,File other){
        return true;
    }
}
