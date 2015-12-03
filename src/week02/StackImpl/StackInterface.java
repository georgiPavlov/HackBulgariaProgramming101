package week02.StackImpl;

/**
 * Created by georgipavlov on 26.11.15.
 */
public interface StackInterface {
    public void push(Object o);
    public Object pop();
    public int length();
    public void clear();
    public boolean isEmpty();
}
