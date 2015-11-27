package week2.Calculator;

/**
 * Created by georgipavlov on 27.11.15.
 */
public class Calculator2 {
    String operation= "+5/2(15*5+2)";

    public void disassembly(){
        String[] part = operation.split("[\\(||\\)]");
        for (int i = 0; i < part.length; i++) {
            System.out.println(part[i]);
            String temp = makeCalc(part[i]);
        }
    }

    public String makeCalc(String part){
        String[] smallParts=part.split("[\\*//]+");
        System.out.println();
        for (int i = 0; i <smallParts.length ; i++) {
            System.out.println(smallParts[i]);
            smallParts[i] = plusMinus(smallParts[i]);

        }
       return "";
    }

    public String plusMinus(String part){
        System.out.println();
        int[] nums= new int[part.length()];
        boolean firstChar = false;
        if(part.charAt(0) == '+' || part.charAt(0) == '-'){
            firstChar=true;
        }
        StringBuilder builder = new StringBuilder();
        int j=0;
        String temp;
        p: for (int i = 0; i <part.length() ; i++) {
            if (firstChar){
                builder.append(part.charAt(i));
                continue p;
            }

            while (part.charAt(i)!= '+' || part.charAt(i) != '-'){
                builder.append(part.charAt(i));
                i++;
            }
            temp= builder.toString();
            builder = new StringBuilder();
            if(temp.charAt(0) == 0){
                temp = temp.substring(1);
                nums[j]=Integer.parseInt(temp);
                j++;
                continue p;
            }
            nums[j]=Integer.parseInt(temp);
        }
        int sum=0;
        for (int i = 0; i <j ; i++) {
            sum +=nums[i];
        }
        return Integer.toString(sum);
    }

    public static void main(String[] args) {
        Calculator2 c=new Calculator2();
        c.disassembly();
    }




}
