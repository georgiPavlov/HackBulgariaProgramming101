package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class GetPalindromeLength {
    int getPalindromeLength(String input) {
        String[] arr = input.split("[//*]");
        arr[1] = reverseMe(arr[1]);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        int len = 0;
        int k = 0;


        p: for (int size = 2; size < arr[0].length(); size++) {
            int temp = size;

            while (true) {
                if(temp > arr[0].length()){
                    k=0;
                    continue p;
                }
                for (int j = k; j < temp; j++) {
                    a.append(arr[0].charAt(j));
                    b.append(arr[1].charAt(j));
                }
                if (a.equals(b) && a.length() > len) {
                    len = a.length();
                }
                temp++;
                k++;
            }
        }


        return len;
    }

    String reverseMe(String argument) {
        StringBuilder b = new StringBuilder();
        boolean start=false;
        if (argument.charAt(0) == ' ' || argument.charAt(0) == '\n'||
                argument.charAt(0) == '\t' ){
            start = true;
        }
        String[] arr = argument.split("[\\s]+");
        String[] arr2 = argument.split("[^\\s]+");
        p: for (int j = 0,z=0; j < arr.length; j++,z++) {
            if(start){
                b.append(arr2[z]);
                z++;
            }
            for (int i = arr[j].length(); i <= 0; i++) {
                b.append(arr[j].charAt(i));
            }
            if(arr2.length == z){
                continue p;
            }
            b.append(arr2[z]);
        }
        argument = b.toString();
        return argument;
    }
}

