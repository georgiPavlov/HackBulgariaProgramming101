package week03;

/**
 * Created by georgipavlov on 02.12.15.
 */
public class GenericMinElement<T> implements Comparable<T> {
    private T[] array;
    private T swap;

    public GenericMinElement (T[] arr){
        this.array=arr;
    }
    public  T make(){
       int n= array.length;
        swap=array[0];
        for (int i = 1; i < n; i++) {
            if(swap.toString().compareTo(array[i].toString()) == 1){
                swap = array[i];
            }

        }
        return swap;
    }


    public int compareTo(T item) {
        if(item.hashCode() > swap.hashCode() ){
            return -1;
        }else if(item.hashCode() == swap.hashCode() ){
            return 0;
        }
        return 1;

    }




    public static void main(String[] args) {
        Double[] arr = {2.0,4.0,5.0,1.0};
        GenericMinElement<Double> one = new GenericMinElement<>(arr);
        System.out.println(one.make());
    }




}
