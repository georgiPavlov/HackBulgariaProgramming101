package week03;

/**
 * Created by georgipavlov on 30.11.15.
 */
public class FactorialFunction {
    public <T1 extends Number > double mul(T1 f){
        long fac=1;
        for (int i = 0; i < f.doubleValue(); i++) {
           fac = (int)f.doubleValue();

        }
        return fac;
    }
}
