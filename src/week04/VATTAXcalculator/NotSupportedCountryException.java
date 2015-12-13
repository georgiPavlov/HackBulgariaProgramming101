package week04.VATTAXcalculator;

/**
 * Created by georgipavlov on 13.12.15.
 */
public class NotSupportedCountryException extends Exception {
     public NotSupportedCountryException(String text){
         super(text);
     }
}
