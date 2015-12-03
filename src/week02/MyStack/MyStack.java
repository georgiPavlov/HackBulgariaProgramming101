package week02.MyStack;

import week02.DoubleList.DoubleList;
import week02.StackImpl.StackInterface;

/**
 * Created by georgipavlov on 27.11.15.
 */
public class MyStack extends DoubleList implements StackInterface{

    @Override
    public void push(Object o) {
        super.add((int)o);
    }

    @Override
    public Object pop() {
        Object p = super.getHead();
        int len=length()-1;
        super.remove(len);
        return p;
    }



    @Override
    public int length() {
        return super.size();
    }
}
