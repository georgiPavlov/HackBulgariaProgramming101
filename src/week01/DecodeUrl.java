package week01;

import java.io.UnsupportedEncodingException;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class DecodeUrl {
    static String decodeUrl(String input) throws UnsupportedEncodingException {
        return java.net.URLDecoder.decode(input, "UTF-8");
    }

    public static void main(String[] args) {
        try {
            System.out.println(DecodeUrl.decodeUrl("jsfdsfsdfksdljfsdkfsdk"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
