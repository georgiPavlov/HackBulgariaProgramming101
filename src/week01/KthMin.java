package week01;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class KthMin {
    int kthMin(int k, int[] array){

        int c=0;
        int n=array.length;
        int swap=0;
        int d=0;

        for (c = 0; c < ( n - 1 ); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (array[d] > array[d+1]) /* For descending order use < */
                {
                    swap       = array[d];
                    array[d]   =   array[d+1];
                    array[d+1] =   swap;
                }
            }
        }

        int t=array[k-1];
        return t;
    }
}
