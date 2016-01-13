package week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by georgipavlov on 12.01.16.
 */
public class SimpleTextFileCompression {
    PrintStream writer;
    Scanner scanner;
    Map<String,Integer> map;
    StringBuilder b;
    File file;


    public void compress(Path filePath) throws FileNotFoundException {
        writer = null;
        scanner = null;
        scanner = new Scanner(filePath.toFile());
        map = new HashMap<>();
        Integer setCount=0;

        while (scanner.hasNext()){
            String key = scanner.next();
            Integer count = map.get(key);
            if(count == null){
                setCount++;
                map.put(key,setCount);
            }

        }

        b= new StringBuilder();
        for(Map.Entry<String,Integer> mapE: map.entrySet()){
            b.append(mapE.getValue());
            b.append(":");
            b.append(mapE.getKey());
            b.append(System.lineSeparator());

        }
        b.append("$");
        b.append(System.lineSeparator());

        file = new File("compressFile.txt");
        writer = new PrintStream(file);
        writer.print(b.toString());
        scanner = new Scanner(filePath.toFile());
        while (scanner.hasNextLine()){
            String[] results = scanner.nextLine().split("[ ]+");
            for (int i = 0; i < results.length; i++) {
                if(map.get(results[i]) != null){
                    writer.print(map.get(results[i]));
                    writer.print("~");
                }
            }
        }

        scanner.close();
        writer.close();
    }

    public void deCompress(Path filePath) throws FileNotFoundException {
        scanner = new Scanner(filePath.toFile());
        writer = new PrintStream("decompressed.txt");
         HashMap<Integer,String> map = new HashMap<>();
        boolean startType = false;
        while(scanner.hasNextLine()){
            String result = scanner.nextLine();
            if(result.equals("#")){
                startType = true;
                continue;
            }
            if(!startType){
                String[] results = result.split("[: ]+");
                map.put(Integer.parseInt(results[1]),results[0]);
            }else if(startType){
                String[] results2 = result.split("[~ ]+");
                for (int i = 0; i < results2.length; i++) {
                    if (map.get(Integer.parseInt(results2[i]))!= null){
                        writer.print(map.get(Integer.parseInt(results2[i])) + " ");
                    }
                    writer.print(System.lineSeparator());
                }
            }

        }
        scanner.close();
        writer.close();
    }
}
