package week01;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class ReverseMe {

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
