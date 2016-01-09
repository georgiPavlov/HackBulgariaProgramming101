package week06.BankAccount;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by georgipavlov on 08.01.16.
 */
public class TheBank implements CLI {
    private ArrayList<BankAccount> accounts ;
    private BankAccount current;
    private String firstName;
    private String lastName;
    private int age;
    private double balance;
    private double  interest;
    private int type;
    private Pattern pattern;
    private Matcher matcher;
    private Scanner scannerForValidation;
    private static final String USERNAME_PATTERN = "^[a-zA-z]{3,15}$";
    private static final String AGE = "^[0-9]{2,3}$";
    private static final String BALANCE = "^[0-9.]{1,6}$";
    private static final String INTEREST = "^[0-9.]{1,4}$";
    private static final String TYPE = "^[0-9]";
    private static final String ID = "^[0-9]{1,10}$";
    private static final String MONEY = "^[0-9.]{1,9}$";
    private static final String MONTH  = "^[0-9]{1,12}$";


    private void validate(final String CONSTANT,String username ) throws BankExeption {
        pattern = Pattern.compile(CONSTANT);

        matcher = pattern.matcher(username);

         if(!matcher.matches()){
             throw new BankExeption("InvalidInput");
         }
    }

    public TheBank() {
        accounts = new ArrayList<>();
        scannerForValidation = new Scanner(System.in);
    }

    @Override
    public void create_bank_account() throws BankExeption {
        Scanner scanner = new Scanner(System.in);
        String res;

        System.out.println("Enter first name");
        res = scanner.nextLine();
        validate(USERNAME_PATTERN,res);
        firstName=res;

        System.out.println("Enter last name");
        res = scanner.nextLine();
        validate(USERNAME_PATTERN,res);
        lastName=res;

        System.out.println("Enter age");
        res = scanner.nextLine();
        validate(AGE,res);
        age = Integer.parseInt(res);

        System.out.println("Enter balance");
        res = scanner.nextLine();
        validate(BALANCE,res);
        balance = Double.parseDouble(res);

        System.out.println("Enter interest");
        res = scanner.nextLine();
        validate(INTEREST,res);
        interest = Double.parseDouble(res);

        System.out.println("Enter type");
        res = scanner.nextLine();
        validate(TYPE,res);
        type = Integer.parseInt(res);
        accounts.add(new BankAccount(firstName,lastName,age,balance,interest,type));

    }

    private BankAccount findId( int id) throws BankExeption {
        BankAccount temp;
        for (int i = 0; i < id; i++) {
             temp = accounts.get(i);
            if(temp.getCount1() == id){
                return temp;
            }
        }
        throw new BankExeption("Wrong ID");
    }

    private void LogIn() throws BankExeption {
        int id;
        System.out.println("Enter ID");
        String res = scannerForValidation.nextLine();
        validate(ID,res);
        id = Integer.parseInt(res);
        current = findId(id);

    }

    @Override
    public void show_history() {
        String arr[] = current.getOperations();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
            System.out.print(arr[i]);
            }
        }

    }

    private void addOperation(String message){
        String arr[] = current.getOperations();
        if(arr[4] != null){
            for (int i = 0; i < arr.length-1; i++) {
                arr[i] = arr[i+1];
            }
            arr[4] = null;
        }
        for (int i = 0; i < arr.length; i++) {
          if(arr[i] != null){
              arr[i] = message;
          }
        }
    }

    @Override
    public void add_money() throws BankExeption {
        String res = validationOperation("Enter money to add",MONEY);
        current.setBalance(current.getBalance() + Double.parseDouble(res));
        addOperation("You add " + res + "$");

    }

    @Override
    public void withdraw_money() throws InsufficientFundsException, BankExeption {
        String res = validationOperation("Enter money to withdraw",MONEY);
        double moneyToWithdraw = Double.parseDouble(res);
        if(moneyToWithdraw > current.getBalance() || (!current.isCanW())){
            throw new InsufficientFundsException(" the balance is smaller than the withdraw or interest is too big");
        }
        current.setBalance(current.getBalance() - moneyToWithdraw);
        addOperation("You withdraw " + res + "$");
    }

    @Override
    public void transfer_money() throws BankExeption, InsufficientFundsException {
        String res = validationOperation("Enter ID of the person you wnat to transfer the money",ID);
        BankAccount temp = findId(Integer.parseInt(res));
        String transferMoney = validationOperation("Enter ID of the person you wnat to transfer the money",MONEY);
        double transferMoneyToDouble = Double.parseDouble(transferMoney);
        if( transferMoneyToDouble > current.getBalance() || (!current.isCanW())){
            throw new InsufficientFundsException(" the balance is smaller than the transfer you ask or interest is too big");
        }
        current.setBalance(current.getBalance() - transferMoneyToDouble);
        temp.setBalance(temp.getBalance() + transferMoneyToDouble);
        addOperation("You transfer to ID:" + res + " " + transferMoney + "$");

    }

    @Override
    public void calculate_amount() throws BankExeption {
        String res = validationOperation("Enter number of months ",MONTH);
        double months = Double.parseDouble(res);
        double interest = current.getInterest();
        double balance  = current.getBalance();
        double result = 0;
        switch (current.getType()){
            case 1:{
             //A(t) = A_0 * (1 + t * r)
                result = balance*(1 +    months/12* interest) ;
                break;
            }case 2:{
                 result = balance*Math.pow(1 + interest / 12,months);
                break;
            }
        }
        System.out.print(result);
        addOperation("You calculate your sum for " + months + " months ant it is " + result + "$");

    }

    private String validationOperation(String message , final String CONSTANT) throws BankExeption {
        System.out.println(message);
        String res = scannerForValidation.nextLine();
        validate(CONSTANT,res);
        return res;
    }


}
