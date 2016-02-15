package week12;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by georgipavlov on 15.02.16.
 */
public class TestJsonPrinter  {
    String json = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":802,\"main\":\"Clouds\"," +
            "\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"base\":\"cmc stations\",\"main\":{" +
            "\"temp\":277.677,\"pressure\":1001.76,\"humidity\":87,\"temp_min\":277.677,\"temp_max\":277.677,\"sea_level" +
            "\":1011.76,\"grnd_level\":1001.76},\"wind\":{\"speed\":7.62,\"deg\":20.0009},\"clouds\":{\"all\":44},\"dt" +
            "\":1455467233,\"sys\":{\"message\":0.0055,\"country\":\"GB\"," +
            "\"sunrise\":1455434170,\"sunset\":1455470038},\"id\":2643743,\"name\":\"London\",\"cod\":200}";

    public void doPOST() throws IOException, URISyntaxException {
    CloseableHttpClient httpclient = HttpClients.createDefault();
        URI uri = new URI("http://localhost:8080/ServletJson");
        HttpPost httpPost = new HttpPost(uri);
        NameValuePair param = new BasicNameValuePair("json",json);
        List<NameValuePair> params = new ArrayList<>();
        params.add(param);
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity);
        System.out.println("result");
        System.out.println(res);

    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        TestJsonPrinter p = new TestJsonPrinter();
        p.doPOST();

    }

}
