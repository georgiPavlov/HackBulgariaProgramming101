package week2.Calculator;
import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) {
        Calculator3 calculator3 = new Calculator3();
        System.out.println("Enter expression:> ");
        Scanner scanner = new Scanner(System.in);
        calculator3.operation1=scanner.nextLine();
        //calculator3.operation1="6*2";
        System.out.println("Output:> ");
        System.out.print(calculator3.firstStage());
    }
    String operation1;
    String operation;
    public String firstStage(){
        StringBuilder tempBuld = new StringBuilder();
        pa:for (int i = 0; i < operation1.length(); i++) {
            if(Character.isWhitespace(operation1.charAt(i))){
                continue pa;
            }
            tempBuld.append(operation1.charAt(i));
        }
        operation = tempBuld.toString();
        StringBuilder b = new StringBuilder();
        p: for (int i = 0; i <operation.length() ; i++) {
            if(operation.charAt(i) != '('){
                b.append(operation.charAt(i));
                continue p;
            }
            String temp = bracket(i);
            if(temp.charAt(0) == '-'){
                b.delete(b.length()-1,b.length());
            }
            b.append(temp);
            int x = temoIndex-i;
            i+=x;
        }
        String result = calculate(b.toString());
        return result;
    }
    int temoIndex=0;
    public String bracket(int index){
        StringBuilder b = new StringBuilder();
        while(true){
            index++;
            if(operation.charAt(index) == '('){
                String temp;
                temp =bracket(index);
                //temp = calculate(temp);
                if(temp.charAt(0) == '-'){
                    b.delete(b.length()-1,b.length());
                }
                b.append(temp);
                int t = temoIndex-index;
                 index = index + t;
            }
            if(operation.charAt(index) == ')'){
                String temp2 = calculate(b.toString());
                b= new StringBuilder();
                b.append(temp2);
                break;
            }
            b.append(operation.charAt(index));
        }
        temoIndex=index;
        return b.toString();
    }

    public String calculate(String calc){
        double sum=0;
        int i=1;
        int j=1;
        boolean b1=false;
        String[] parts = calc.split("[+-]+");
        String[] operators = calc.split("[\\*//0-9.]+");
        if(calc.charAt(0) == '-' || calc.charAt(0) == '+') {
            b1 = true;
            i = 2;
        }
        for (; i <parts.length ; i++,j++) {
            parts[i] = MultiDiv(parts[i]);
            parts[i].trim();
            if(operators[j].charAt(0) == '+'){
            sum += Double.parseDouble(parts[i]);
            }else {
                sum -= Double.parseDouble(parts[i]);
            }
        }
        if(b1){
            parts[1] = MultiDiv(parts[1]);
            sum -= Double.parseDouble(parts[1]);
        }else {
            parts[0] = MultiDiv(parts[0]);
            sum += Double.parseDouble(parts[0]);
        }
        return Double.toString(sum);
    }

    private String MultiDiv(String calc){
        int i=1;
        int j=1;
        String[] parts = calc.split("[\\*//]+");
        String[] operators = calc.split("[0-9.]+");
        double sum= Double.parseDouble(parts[0]);
        for (; i <parts.length ; i++,j++) {
            parts[i].trim();
            if(operators[j].charAt(0) == '*'){
                sum *= Double.parseDouble(parts[i]);
            }else if(operators[j].charAt(0) == '/') {
                sum /= Double.parseDouble(parts[i]);
            }
        }
        return Double.toString(sum);
    }
}
