package week2.Calculator;

/**
 * Created by georgipavlov on 27.11.15.
 */
public class Calculator3 {
    String operation = "2+(-4+5+(5+3))-2";
    public String firstStage(){
        StringBuilder b = new StringBuilder();
        p: for (int i = 0; i <operation.length() ; i++) {
            if(operation.charAt(i) != '('){
                b.append(operation.charAt(i));
                continue p;
            }
            String temp = bracket(i);
            b.append(temp);
            int x = temoIndex-i;
            i+=x+1;
        }

      return "";
    }

    int count=0;
    int temoIndex=0;
    public String bracket(int index){
        StringBuilder b = new StringBuilder();
        while(true){
            count++;
            index++;
            if(operation.charAt(index) == '('){
                String temp;
                temp =bracket(index);
                temp = calculate(temp);
                if(temp.charAt(0) == '-'){
                b.substring(0,b.length()-1);
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
        String[] operators = calc.split("[0-9]");
        if(calc.charAt(0) == '-' || calc.charAt(0) == '+') {
            b1 = true;
            i = 2;
        }
        for (; i <parts.length ; i++,j++) {
            //parts[i] = MultiDiv(parts[i]);
            parts[i].trim();
            if(operators[j].charAt(0) == '+'){
            sum += Double.parseDouble(parts[i]);
            }else {
                sum -= Double.parseDouble(parts[i]);
            }
        }
        if(b1){
            sum -= Double.parseDouble(parts[1]);
        }else {
            sum += Double.parseDouble(parts[0]);

        }
        return Double.toString(sum);
    }

    private String MultiDiv(String calc){
        int i=1;
        int j=1;
        boolean b1=false;
        String[] parts = calc.split("[\\*//]+");
        String[] operators = calc.split("[0-9]");
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




    public static void main(String[] args) {
        Calculator3 calculator3 = new Calculator3();
        calculator3.firstStage();
    }
}
