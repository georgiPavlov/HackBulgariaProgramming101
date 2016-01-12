package week06.BankAccount;

import java.util.Scanner;

/**
 * Created by georgipavlov on 10.01.16.
 */
public class MainBank {

    public static void main(String[] args) {
       caseWork();
    }

    private static void case2Work(StartBank bank){
        int key;
        do {
            key = menu2();
            switch (key) {
                case 1: {
                    bank.showHistory();
                    break;
                }case 2: {
                    bank.calculate_amount();
                    break;
                }case 3: {
                    bank.transfer_money();
                    break;
                }case 4: {
                    bank.withdraw_money();
                    break;
                }case 5: {
                    System.out.printf("\n\n           _-_-Goodbye!-_-_\n\n");
                }default:{
                    System.out.print("You enter wrong number or the input is not valid \n");
                }
            }
        } while (key != 5);
    }

    private static void caseWork(){
        StartBank bank = new StartBank();
        int key;
        do {
            key = menu();
            switch (key) {
                case 1: {
                    bank.createBankAccount();
                    break;
                }case 2: {
                    bank.logIn();
                    case2Work(bank);
                    break;
                }
                case 3:{
                    bank.backUP();
                    System.out.println("bye bye for now");
                }
                default:{
                   // System.out.print("You enter wrong number or the input is not valid \n");
                }
            }
        } while (key != 3);
    }

    private static int menu2(){
        Scanner scanner = new Scanner(System.in);
        String result;
        System.out.printf("************************* MENU *************************\n\n\n");
        System.out.printf("Enter 1 to show history \n");
        System.out.printf("ENTER 2 to calculate amount \n");
        System.out.printf("Enter 3 to transfer money \n");
        System.out.printf("Enter 4 to withraw money\n");
        System.out.printf("Enter 5 to EXIT\n");
        result = scanner.nextLine();
        for (int i = 0; i < result.length() ; i++) {
            if(!Character.isDigit(result.charAt(i))){
                return 0;
            }
        }
        return Integer.parseInt(result);
    }

    private static int menu(){
        Scanner scanner = new Scanner(System.in);
        String result;
        System.out.printf("************************* MENU *************************\n\n\n");
        System.out.printf("Enter 1 to create bank account. \n");
        System.out.printf("Enter 2 to logIn history \n");
        System.out.printf("Enter 3 to EXIT\n");
        result = scanner.nextLine();
        for (int i = 0; i < result.length() ; i++) {
            if(!Character.isDigit(result.charAt(i))){
                return 0;
            }
        }
        return Integer.parseInt(result);
    }
}
