package week1;

import java.io.UnsupportedEncodingException;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class DecodeUrl {
    String decodeUrl(String input) throws UnsupportedEncodingException {
        return java.net.URLDecoder.decode(input, "UTF-8");
    }
}
