package week08;
import com.sun.xml.internal.ws.client.sei.MethodHandler;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.util.Scanner;


/**
 * Created by georgipavlov on 21.01.16.
 */
public class DownloadFileprogram {
    public static void download() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://www.thinkstockphotos.com/CMS/StaticContent/Hero/TS_AnonHP_462882495_01.jpg");
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream in = new BufferedInputStream(entity.getContent());
            OutputStream out = new BufferedOutputStream(new FileOutputStream("0011.jpg"));
            while (true){
                int read =in.read();
                if(read == -1){
                    break;
                }
                out.write(read);
            }
            in.close();
            out.close();
        }

    }

    public static void main(String[] args) throws IOException {
        download();
    }





}
