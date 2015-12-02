package week03;

/**
 * Created by georgipavlov on 02.12.15.
 */
public class GenericMinElement<T> {
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


    private int compareTo(T item) {
        if(item.hashCode() > swap.hashCode() ){
            return -1;
        }else if(item.hashCode() == swap.hashCode() ){
            return 0;
        }
        return 1;

    }

    public static void main(String[] args) {
        Integer[] arr = {2,4,5,1};
        GenericMinElement<Integer> one = new GenericMinElement<>(arr);
        System.out.println(one.make());
    }




}
