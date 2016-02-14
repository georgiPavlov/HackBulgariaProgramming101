package week11;


import com.sun.deploy.net.HttpUtils;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

/**
 * Created by georgipavlov on 08.02.16.
 */
public class WeatherForcastingTool {
    ArrayList<String> keys;
    ArrayList<JSONArray> arrays;
    Hashtable<String,String> weatherInfo;
    Hashtable<String,String> weatherTable;




    public  JSONObject getJsonForWeather(String link) throws IOException, ClassNotFoundException, JSONException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(link);
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();


        JSONObject object = null;
        JSONArray array;
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null){
            responseStrBuilder.append(inputStr);}
        object = new JSONObject(responseStrBuilder.toString());
        return object;
    }



    public static void printJson(JSONObject object){
        Iterator it = object.keys();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        try {
           JSONArray array = (JSONArray)object.get("weather");
           // System.out.println(array.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public  void voidGetKeys(JSONObject object) throws JSONException {
        weatherTable = new Hashtable<>();
        arrays =new ArrayList<>();
        Iterator it = object.keys();
        String result;
        while(it.hasNext()) {
           // result = it.next().toString();
           // keys.add(result);
            String js = it.next().toString();
            Object json = object.get(js);
          //  System.out.println(js);

            if (json instanceof JSONObject){
               // System.out.println("object " + js);
                Iterator iterator = ((JSONObject) json).keys();
                while (iterator.hasNext()){
                    //System.out.println("i am in");
                    String key = iterator.next().toString();
                   // System.out.println("      " + key);
                  //  System.out.println("     value: " + ((JSONObject)json).get(key));
                    weatherTable.put(key,((JSONObject)json).get(key).toString());

                }
                //System.out.println(((JSONObject) json).get(js));
//                weatherInfo.put(js.toString(),(String) ((JSONObject) json).get(js.toString()));
            }
            //you have an object
            else if (json instanceof JSONArray){
                try {
                    //System.out.println(js);
                    arrays.add((JSONArray) json);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                //System.out.println(js + " " +  object.get(js) + "  single");
                weatherTable.put(js,object.get(js).toString());
            }

        }

    }

    public void createWeatherTable() throws JSONException {

        JSONArray it;
        for (int i = 0; i < arrays.size() ; i++) {
           it =  arrays.get(i);
            for (int j = 0; j < it.length(); j++) {
                Iterator iterator = it.getJSONObject(i).keys();
                     while (iterator.hasNext()){
                    String key = iterator.next().toString();
                  //  System.out.println(key);
                    weatherTable.put(key, String.valueOf(it.getJSONObject(i).get(key)));
                }
            }

        }
    }

    public void printWeathertable(){

        for (Map.Entry<String, String> entry : weatherTable.entrySet()) {
            System.out.println("key: " + entry.getKey() +   "  value: " + entry.getValue());
        }
    }


    public static void main(String[] args) throws JSONException, IOException, ClassNotFoundException {
         WeatherForcastingTool tool = new WeatherForcastingTool();
         JSONObject o =    tool.getJsonForWeather("http://api.openweathermap.org/data/2.5" +
                    "/weather?q=Sofia,bg&appid=44db6a862fba0b067b1930da0d769e98");
        //printJson(o);
        tool.voidGetKeys(o);
        tool.createWeatherTable();
       // tool.createWeatherTable();
        tool.printWeathertable();

    }



}
