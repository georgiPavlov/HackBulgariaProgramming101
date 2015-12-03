package week01;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class Reduce_file_path {
    public static String reduce_file_path(String path){
        if(path.charAt(0) != '/'){
            System.out.println("Invalid path");
            return "";
        }
        StringBuilder temp = new StringBuilder();
        int size=0;
        String[] arr = path.split("[/]+");
        p:for (int i = 1; i <arr.length ; i++) {
            System.out.println(arr[i]);

            if(arr[i].charAt(0) == '.' && arr[i].length() == 1){
                System.out.println("res");
                continue p;
            } else if(arr[i].equals("..")){
                if(temp.length() == 0){
                    System.out.println("invalid path");
                    return "";
                }
                temp.delete(size,temp.length());
                continue p;
            }
            size=temp.length();
            temp.append(arr[i]);
            temp.append("/");

        }
        String result = "/";
        if(!(temp.length() == 0)){ result +=temp; }
        return result;
    }
}
