package week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by georgipavlov on 11.01.16.
 */
public class Properties {
    Scanner scanner;
    Map<String, String> parseProperties;
    File file;

    public Properties() throws FileNotFoundException {
         file = new File("a.properties");
        this.scanner = new Scanner(file);
        this.parseProperties =new HashMap<>();

    }

    public void doTheMagic(){
        while(scanner.hasNextLine()){

            String result = scanner.nextLine();
            doSomeMoreMagic(result);
        }

    }

    public void doSomeMoreMagic(String line){
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();
        boolean addingValue = false;
        boolean t = true;

        for (int i = 0; i <line.length() ; i++) {
            if(line.charAt(i) == '#'){
                if(i == 0){
                    return;
                }else {
                    parseProperties.put(key.toString(),value.toString());
                    return;
                }
            }else if (value.charAt(i) == '=' && t){
                addingValue = true;
                t=false;
                continue;
            }

            if(addingValue){
                value.append(line.charAt(i));
            }else {
                key.append(line.charAt(i));
            }


        }
        parseProperties.put(key.toString(),value.toString());
        scanner.close();


    }


}
