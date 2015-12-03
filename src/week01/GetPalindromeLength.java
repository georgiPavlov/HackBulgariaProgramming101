package week01;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class GetPalindromeLength {


    static int getPalindromeLength1(String input){
        if(input == null || input == ""){
            return 0;
        }
        String[] arr = input.split("[//*]");
        StringBuilder z = new StringBuilder();
        z.append(arr[1]);

        arr[1] =z.reverse().toString();
        if(arr[1].length() < arr[0].length()){
            String temp[] = new String[1];
            temp[0]=arr[1];
            arr[1]=arr[0];
            arr[0]=temp[0];
        }

        int count=0;
        int result =0;
        int k=0;
        int add;
        while (arr[1].length() <=arr[1].length()-k){
            add=k;
            for (int i = 0; i <arr[0].length() ; i++,add++) {
               if(arr[0].charAt(i) == arr[1].charAt(add)){
                   count++;
               }else {
                   count =0;
               }
                if(count > result){
                    result=count;
                }
                k++;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(GetPalindromeLength.getPalindromeLength1("10*100"));
    }
}

