package week08;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by georgipavlov on 22.01.16.
 */
public class WebReader {


    private static final int MAX_COUNT_OF_PAGES = 5;
    private String word;
    private boolean found = false;

    public void start(String startLink,String word) throws IOException {
        this.word = word;
        search(0, startLink );
    }


    private void search(int count,String link) throws IOException {
        if(count > MAX_COUNT_OF_PAGES){
            return;
        }
        HashSet<String> results ;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(link);
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream in = new BufferedInputStream(entity.getContent());
            StringBuilder b = new StringBuilder();
            Scanner scanner = new Scanner(entity.getContent());
            while (scanner.hasNextLine()){
                String result = scanner.nextLine();
                b.append(result);
                b.append(System.lineSeparator());
                //System.out.println(result);
            }

            if(b.toString().contains(word)){
                System.out.println("-----------------------------------------------");
                System.out.println("---------------------- founded ---------------" );
                System.out.println("-----------------------------------------------");
                System.out.println( "LINK TO FOLLOW: " +  link );
                System.out.println("-----------------------------------------------");
                System.out.println("-----------------------------------------------");
                System.out.println("-----------------------------------------------");
                found = true;
                return;
            }else {
                results = getAllLinks(b.toString());
                for (Iterator<String> it = results.iterator(); it.hasNext();) {
                    String getLink = it.next();
                    System.out.println(getLink);
                    search(count+1,getLink);
                    if(found){
                        return;
                    }
                }
            }
            in.close();
            response.close();

        }
    }


    public   HashSet<String> getAllLinks(String content) {
        HashSet<String> resultList = new HashSet<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            if(!matcher.group(1).contains("http")){
                continue;
            }
            resultList.add(matcher.group(1));
        }
        return resultList;
    }


    public static void main(String[] args) throws IOException {
       WebReader web = new WebReader();
        web.start("http://smartnews.bg/", "Планета Девет");
    }


}
