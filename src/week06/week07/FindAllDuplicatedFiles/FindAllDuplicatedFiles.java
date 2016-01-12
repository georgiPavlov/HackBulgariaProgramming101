package week06.week07.FindAllDuplicatedFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by georgipavlov on 12.01.16.
 */
public class FindAllDuplicatedFiles {
    ArrayList<String> comparedFiles;
    ArrayList<String> print;


    public void doWork(Path path) throws IOException {
        comparedFiles = new ArrayList<>();
        File file = path.toFile();
        String[] files = file.list();
        for (int i = 0; i < files.length; i++) {
            if(Files.isSymbolicLink(Paths.get(files[i]))){
                Path path2= Files.readSymbolicLink(Paths.get(files[i]));
                for (int j = 0; j <comparedFiles.size() ; j++) {
                    if(!(compare(new File(comparedFiles.get(i)),path2.toFile()))){
                        continue;
                    }
                }
                if(!Files.isRegularFile(file.toPath())){
                    continue;
                }
                print.add(files[i]);
                search(path2.toFile(),file);
                comparedFiles.add(path2.toFile().getAbsolutePath());
                printPaths();
             }
            String result= file.getAbsolutePath() + "/"+  files[i];
            File file2 = new File(result);
            if(file2.isFile() && file.length() < 512){
                for (int j = 0; j <comparedFiles.size() ; j++) {
                    if(!(compare(new File(comparedFiles.get(i)),file2))){
                        continue;
                    }
                }
                if(!Files.isRegularFile(file.toPath())){
                    continue;
                }
                print.add(file2.getAbsolutePath());
                search(file2,file);
                comparedFiles.add(file2.getAbsolutePath());
                printPaths();
            }else if(file2.isDirectory()){
            doWork(file2.toPath());
            }

        }
    }


    public void search(File fileSearch,File directory) throws IOException {
        String[] files = directory.list();
        for (int i = 0; i < files.length ; i++) {
            File file = new File(directory.getAbsolutePath() + "/" + files[i] );
            if(Files.isSymbolicLink(Paths.get(files[i]))){
                Path path2= Files.readSymbolicLink(Paths.get(files[i]));
                if(!Files.isRegularFile(file.toPath())){
                    continue;
                }
                search(fileSearch,path2.toFile());
            }
            if(file.isFile() && file.length() < 512 ){
                if(!Files.isRegularFile(file.toPath())){
                    continue;
                }
                compare(fileSearch,file);
            }else if(file.isDirectory()){
                search(fileSearch,file);
            }
            
        }
    }

    public boolean compare(File start,File other) throws FileNotFoundException {
        if(start.length() != other.length()){
            return false;
        }
        Scanner scanner;
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        scanner = new Scanner(start);
        while (scanner.hasNextLine()){
            a.append(scanner.nextLine());
            a.append(System.lineSeparator());
        }
        scanner = new Scanner(other);
        while (scanner.hasNextLine()){
            b.append(scanner.nextLine());
            b.append(System.lineSeparator());
        }

        byte[] bytesB = b.toString().getBytes();
        byte[] bytesA = a.toString().getBytes();
        if(bytesA.length != bytesB.length){
            return false;
        }
        for (int i = 0; i < bytesA.length; i++) {
            if(bytesA[i]!=bytesB[i]){
                return false;
            }
        }
        print.add(other.getAbsolutePath());
        return true;
    }

    public void printPaths(){
        if(print.size() < 2){
            return;
        }

        for (int i = 0; i <print.size() ; i++) {
            System.out.println(print.get(i));
        }
        print = new ArrayList<>();
    }
}
