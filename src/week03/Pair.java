package week03;

/**
 * Created by georgipavlov on 30.11.15.
 */
public class Pair<T,S> {
    private  T FirstObject;
    private  S SecondObject;

    public T getFirstObject() {
        return FirstObject;
    }

    public void setFirstObject(T firstObject) {
        FirstObject = firstObject;
    }

    public S getSecondObject() {
        return SecondObject;
    }

    public void setSecondObject(S secondObject) {
        SecondObject = secondObject;
    }
}
