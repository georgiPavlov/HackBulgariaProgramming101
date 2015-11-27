package week2.MyStack;

import week2.DoubleList.DoubleList;
import week2.StackImpl.StackInterface;

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
        return super.getPop();
    }



    @Override
    public int length() {
        return super.size();
    }
}
