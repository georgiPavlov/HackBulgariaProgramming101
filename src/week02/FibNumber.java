package week02;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class FibNumber {
    static StringBuilder b = new StringBuilder();
    public static int fibNumber(int number){
        if(number == 1 || number == 2){
            b.append(1);
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        b.append(fibo1);
        b.append(fibo2);

        for(int i= 3; i<= number; i++){
            fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci number
            fibo1 = fibo2;
            fibo2 = fibonacci;
            b.append(fibonacci);

        }
        return fibonacci;}

    public static void main(String[] args) {
       FibNumber.fibNumber(2);
        System.out.println(b.toString());
    }
}
