package week03.StackGeneric;

/**
 * Created by georgipavlov on 30.11.15.
 */
public interface GenericStackInterface <T> {

        public void push(T o);
        public T pop();
        public int length();
        public void clear();
        public boolean isEmpty();

}
