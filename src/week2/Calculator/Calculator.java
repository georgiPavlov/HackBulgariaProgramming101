package week2.Calculator;

import java.util.Arrays;

/**
 * Created by georgipavlov on 27.11.15.
 */
public class Calculator {
    private String calculations="2*(10*5)";

    public Calculator(){
        engine();
    }
    public void engine(){
        String temp;
        String[] part=calculations.split("[\\(||\\)]");
        String allPartsInOne;
        int operators=part.length;
        for(int i=0;i<part.length;i++){
            if(operators>0 && part[0].equals("")){
                part= Arrays.copyOfRange(part,1,operators);
            }
            temp= disassembly(part[i]);
            part[i]=temp;
            //System.out.println(part[i]);
        }
        allPartsInOne=assembly(part);
        System.out.println(disassembly(allPartsInOne));
        //disassembly(allPartsInOne)
    }

    public String disassembly(String somePart){
        if(Character.isDigit(somePart.charAt(0)) && Character.isDigit(somePart.charAt(somePart.length()-1))){
            String temp;
            String[] toDigit=somePart.split("[+-]+");
            String[] toChar1=somePart.split("[1234567890*/]+");
            //System.out.println(toChar1[1]);
            int[] numbers=new int[toDigit.length];
            for(int i=0;i<toDigit.length;i++){
                temp=disassemblyMulti(toDigit[i]);
                numbers[i]=Integer.parseInt(temp);
                //System.out.println(temp);

            }

            int result=plusThis(toChar1, numbers);
            //System.out.println(result);
            somePart=Integer.toString(result);
        }
        //System.out.println(somePart);
        return somePart;
    }

    public String disassemblyMulti(String somePart){
        //System.out.print(somePart);
        String[] toDigit=somePart.split("[/*]+");
        String[] toChar=somePart.split("\\d");
        int[] numbers=new int[toDigit.length];
        for(int i=0;i<toDigit.length;i++){
            numbers[i]=Integer.parseInt(toDigit[i]);
            // System.out.println(toChar[i]);
            // System.out.println(numbers[i]);
        }

        int result=multi(toChar,numbers);
        return Integer.toString(result);
    }

    public int multi(String []toChar,int[] numbers){
        int result=numbers[0];
        //System.out.print(numbers[0]);
        //System.out.print(toChar[0]);
        int operators=toChar.length;
        if(operators>0){
            toChar= Arrays.copyOfRange(toChar,1,operators);
        }
        for(int i=1;i<numbers.length;i++){
            if(toChar[i-1].equals("*")){
                result = result * numbers[i];
                //System.out.println(result);
            } else if(toChar[i-1].equals("/")){
                result /=numbers[i];
            }
        }
        //System.out.println(result);
        return  result;
    }

    public int plusThis(String []toChar,int[] numbers){
        int result=numbers[0];
        //System.out.print(numbers[0]);
        //System.out.print(toChar[1]);
        int operators=toChar.length;
        if(operators>0){
            toChar= Arrays.copyOfRange(toChar, 1, operators);
        }
        for(int i=1;i<numbers.length;i++){
            if(toChar[i-1].equals("+")){
                result +=numbers[i];
            } else if(toChar[i-1].equals("-")){
                result -=numbers[i];
            }
        }
        return  result;
    }

    public String assembly(String[] part){
        String assemblyParts="";
        for(int i=0;i<part.length;i++){
            assemblyParts +=part[i];
        }
        return assemblyParts;
    }

    public static void main(String[] argv){
        Calculator calculator = new Calculator();

    }
}
