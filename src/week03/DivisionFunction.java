package week03;

/**
 * Created by georgipavlov on 30.11.15.
 */
public class DivisionFunction{
    public <T1 extends Number,T2 extends Number> double div(T1 f,T2 r){
        return f.doubleValue() * r.doubleValue();
    }

}
