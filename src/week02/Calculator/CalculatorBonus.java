package week02.Calculator;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by georgipavlov on 29.11.15.
 */

public class CalculatorBonus {

    public static void main(String[] args) {
        CalculatorBonus calculator3 = new CalculatorBonus();
        System.out.print("Enter expression:> ");
        Scanner scanner = new Scanner(System.in);
        calculator3.operation1 = scanner.nextLine();
        System.out.println("Output:> " + calculator3.firstStage());
    }

    String operation1;
    String operation;

    public String firstStage() {
        boolean fac = false;
        int count = -1;
        StringBuilder tempBuld = new StringBuilder();
        pa:
        for (int i = 0; i < operation1.length(); i++) {
            if (Character.isWhitespace(operation1.charAt(i))) {
                continue pa;
            }
            tempBuld.append(operation1.charAt(i));
        }
        operation = tempBuld.toString();
        StringBuilder b = new StringBuilder();
        p:
        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i) != '(') {
                b.append(operation.charAt(i));
                continue p;
            } else if (operation.charAt(i) == ')') {
                continue p;
            }
            String temp = bracket(i);
            if (temp.charAt(0) == '-') {
                if (!b.toString().equals("")) {
                    temp = bracketStage(b, temp);
                }
            }
            b.append(temp);
            i = temoIndex;
            //i+=x+count;
        }
        String result = calculate(b.toString());
        if (fac) {
            result = fac((long) Double.parseDouble(b.toString()));
        }
        return result;
    }

    String fac(long n) {

        long fac = 1;
        BigInteger bigFac = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            bigFac.multiply(BigInteger.valueOf(i));
            if (bigFac.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1 ||
                    bigFac.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) == -1) {
                System.out.println("To big value");
                return "";
            }
            fac *= i;

        }
        return Long.toString(fac);
    }

    int temoIndex = 0;

    public String bracket(int index) {
        StringBuilder b = new StringBuilder();
        while (true) {
            index++;
            if (operation.charAt(index) == '(') {
                String temp;
                temp = bracket(index);
                if (temp.charAt(0) == '-') {
                    if (!b.toString().equals("")) {
                        temp = bracketStage(b, temp);
                    }
                }
                b.append(temp);
                int t = temoIndex - index;
                index = index + t + 1;
            }
            if (operation.charAt(index) == ')') {
                String temp2 = calculate(b.toString());
                b.delete(0, b.length());
                b.append(temp2);
                break;
            }
            b.append(operation.charAt(index));
        }
        temoIndex = index;
        return b.toString();
    }

    public String calculate(String calc) {
        double sum = 0;
        int i = 1;
        int j = 1;
        boolean b1 = false;
        String[] parts = calc.split("[+-]+");
        String[] operators = calc.split("[!\\*//0-9.\\^]+");
        if (calc.charAt(0) == '-' || calc.charAt(0) == '+') {
            b1 = true;
            i = 2;
        }
        for (; i < parts.length; i++, j++) {
            parts[i] = multiDiv(parts[i]);
            //
            parts[i].trim();
            if (operators[j].charAt(0) == '+') {
                sum += Double.parseDouble(parts[i]);
                powOdd = true;
            } else {
                if (!powOdd) {
                    sum -= Double.parseDouble(parts[i]) * -1;
                    powOdd = true;
                } else {
                    sum -= Double.parseDouble(parts[i]);
                }
            }
        }
        if (b1) {
            parts[1] = multiDiv(parts[1]);
            if (!powOdd) {
                sum -= Double.parseDouble(parts[1]) * -1;
                powOdd = true;
            } else {
                sum -= Double.parseDouble(parts[1]);
            }
        } else {
            parts[0] = multiDiv(parts[0]);
            sum += Double.parseDouble(parts[0]);
            powOdd = true;
        }
        return Double.toString(sum);
    }

    private String multiDiv(String calc) {
        int i = 1;
        int j = 1;
        String[] parts = calc.split("[\\*//]+");
        String[] operators = calc.split("[0-9.\\^!]+");
        if (parts[0].contains("^")) {
            parts[0] = pow(parts[0]);
        } else if (parts[0].contains("!")) {
            parts[0] = facStage(parts[0]);
        }
        double sum = Double.parseDouble(parts[0]);
        for (; i < parts.length; i++, j++) {
            parts[i] = pow(parts[i]);
            parts[i].trim();
            if (operators[j].charAt(0) == '*') {
                sum *= Double.parseDouble(parts[i]);
            } else if (operators[j].charAt(0) == '/') {
                sum /= Double.parseDouble(parts[i]);
            }
        }
        return Double.toString(sum);
    }

    private boolean powOdd = true;

    String pow(String calc) {
        String[] parts = calc.split("[\\^]+");
        String[] operators = calc.split("[0-9.!]+");
        parts[0] = facStage(parts[0]);
        double sum = Double.parseDouble(parts[0]);
        if (parts.length > 1) {
            parts[1] = facStage(parts[1]);
            if (Double.parseDouble(parts[1]) / 2 == (int) (Double.parseDouble(parts[1]) / 2)) {
                powOdd = false;
            }
            sum = Math.pow(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
        }
        for (int i = 2; i < parts.length; i++) {
            parts[i] = facStage(parts[i]);
            if (Double.parseDouble(parts[i]) / 2 == (int) (Double.parseDouble(parts[i]) / 2)) {
                powOdd = false;
            }
            sum = Math.pow(sum, Double.parseDouble(parts[i]));
        }
        return Double.toString(sum);
    }

    public String facStage(String calc) {
        String[] parts = calc.split("[!]+");
        String[] operators = calc.split("[0-9.]+");
        double sum = Double.parseDouble(parts[0]);
        if (operators.length > 1) {
            sum = Double.parseDouble(fac((long) Double.parseDouble(parts[0])));
        }
        return Double.toString(sum);
    }


    String multiDivBracket(String part) {
        for (int i = part.length() - 1; i >= 0; i--) {
            if (part.charAt(i) == '-') {
                if (i == 0) {
                    part = part.substring(i + 1, part.length());
                } else {
                    part = part.substring(0, i) + '+' + part.substring(i + 1, part.length());
                }
                return part;
            } else if (part.charAt(i) == '+') {
                part = part.substring(0, i) + '+' + part.substring(i + 1, part.length());
                return part;
            }
        }
        return '-' + part;
    }

    String bracketStage(StringBuilder b, String temp) {
        if (b.toString().charAt(b.length() - 1) == '-') {
            temp = '+' + temp.substring(1, temp.length() - 1);
            b.delete(b.length() - 1, b.length());
        } else if (b.toString().charAt(b.length() - 1) == '+') {
            b.delete(b.length() - 1, b.length());
        } else {
            String t = multiDivBracket(b.toString());
            b.delete(0, b.length());
            b.append(t);
            temp = temp.substring(1, temp.length());
        }
        return temp;
    }
}
