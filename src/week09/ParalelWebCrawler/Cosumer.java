package week09.ParalelWebCrawler;

import org.apache.http.HttpEntity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by georgipavlov on 01.02.16.
 */
public class Cosumer extends DataBaceWeb implements Runnable {
    public boolean loop = true;


    @Override
    public void run() {
        while (loop){
            while (entities.size() == 0){
                try {
                    entities.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                workWithEntity(entities.poll());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void workWithEntity(HttpEntity entity) throws IOException {
        if (entity != null) {
            InputStream in = new BufferedInputStream(entity.getContent());
            StringBuilder b = new StringBuilder();
            Scanner scanner = new Scanner(entity.getContent());
            while (scanner.hasNextLine()) {
                String result = scanner.nextLine();
                b.append(result);
                b.append(System.lineSeparator());
                //System.out.println(result);
            }

            if (b.toString().contains(word)) {
                System.out.println("-----------------------------------------------");
                System.out.println("---------------------- founded ---------------");
                System.out.println("-----------------------------------------------");
                System.out.println("LINK TO FOLLOW: " + link);
                System.out.println("-----------------------------------------------");
                System.out.println("-----------------------------------------------");
                System.out.println("-----------------------------------------------");
                found = true;
                return;
            } else {
                getAllLinks(b.toString());
                for (Iterator<String> it = link.iterator(); it.hasNext(); ) {
                    String getLink = it.next();
                    System.out.println(getLink);

                }
            }
            in.close();

        }


    }

    public void getAllLinks(String content) {
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            if(!matcher.group(1).contains("http")){
                continue;
            }
            link.add(matcher.group(1));
        }

    }
}
