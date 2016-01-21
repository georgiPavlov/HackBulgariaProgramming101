package week08;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by georgipavlov on 22.01.16.
 */
public class WebReader {
    public static void operation() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        String link = "http://javac.bg/";
        HttpGet httpget = new HttpGet(link);
        String format = link.substring(link.length()-3,link.length());
        System.out.println(format);
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream in = new BufferedInputStream(entity.getContent());
            OutputStream out = new BufferedOutputStream(new FileOutputStream("0011." + format));
            StringBuilder b = new StringBuilder();
            Scanner scanner = new Scanner(entity.getContent());

            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            in.close();
            out.close();
        }


    }

    public static void main(String[] args) throws IOException {
        operation();
    }
}
