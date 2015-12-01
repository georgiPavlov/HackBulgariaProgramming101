package week03;

/**
 * Created by georgipavlov on 30.11.15.
 */
public class PowerFunction {
    public <T1 extends Number,T2 extends Number> double pow(T1 f,T2 r){
        return Math.pow(f.doubleValue(),r.doubleValue());
    }
}
