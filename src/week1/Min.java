package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class Min {
    int min(int[] arr) {
        int j=0;
        try {
            j = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (j > arr[i]) {
                    j = arr[i];
                }
            }
            return j;
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return j;

    }
}
