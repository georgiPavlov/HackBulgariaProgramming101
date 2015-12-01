package week03;

/**
 * Created by georgipavlov on 30.11.15.
 */
public class Triple<T,S,P> {
    private T FirstObject;
    private S SecondObject;
    private P Object1;

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

    public P getObject1() {
        return Object1;
    }

    public void setObject1(P object1) {
        Object1 = object1;
    }
}
