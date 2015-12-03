package week02.MyStack;

import week02.DoubleList.DoubleList;
import week02.StackImpl.StackInterface;

/**
 * Created by georgipavlov on 27.11.15.
 */
public class FactotyStack implements StackInterface {
    private DoubleList one = new DoubleList(){
        @Override
        public int getHead() {
            Object o = super.getHead();
            int len=length()-1;
            super.remove(len);
            return (int)o;

        }
    };
    private void factory(int c,Object v){

        switch (c){

            case 1:{
                one.add((int)v);
                break;
            }
            case 2:{
                pop=one.getHead();
                break;
            }
            case 3:{
                size=one.size();
                break;
            }
            case 4:{
                one.clear();
                break;
            }
            case 5:{
                t=one.isEmpty();
                break;
            }
        }
    }

    @Override
    public void push(Object o) {
        factory(1,o);
    }

    Object pop;
    @Override
    public Object pop() {
        factory(2,"");
        return pop;
    }


    int size;
    @Override
    public int length() {
        factory(3,"");
        return size;
    }

    @Override
    public void clear() {
        factory(4,"");

    }

    boolean t=false;
    @Override
    public boolean isEmpty() {
        factory(5,"");
        return t;
    }
}
