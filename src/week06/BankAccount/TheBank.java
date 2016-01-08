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
    private String firstName;
    private String lastName;
    private int age;
    private double balance;
    private double  interest;
    private int type;
    private Pattern pattern;
    private Matcher matcher;
    private static final String USERNAME_PATTERN = "^[a-zA-z]{3,15}$";
    private static final String AGE = "^[0-9]{2,3}$";
    private static final String BALANCE = "^[0-9.]{1,6}$";
    private static final String INTEREST = "^[0-9.]{1,4}$";
    private static final String TYPE = "^[0-9]";
    private static final String ID = "^[0-9]{1,10}$";


    private void validate(final String CONSTANT,String username ){
        pattern = Pattern.compile(CONSTANT);

        matcher = pattern.matcher(username);

         if(!matcher.matches()){
             try {
                 throw new BankExeption("InvalidInput");
             } catch (BankExeption bankExeption) {
                 bankExeption.getMessage();
             }

         }
    }

    public TheBank() {
        accounts = new ArrayList<>();
        scannerForValidation = new Scanner(System.in);
    }

    @Override
    public void create_bank_account() {
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

        try {
            accounts.add(new BankAccount(firstName,lastName,age,balance,interest,type));
        } catch (BankExeption bankExeption) {
            bankExeption.getMessage();
            create_bank_account();
        }


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

    private Scanner scannerForValidation;

    private BankAccount current;
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

    @Override
    public void add_money() {
      System.out.println("Enter money to add");
        String res = scannerForValidation.nextLine();
        validate();
    }

    @Override
    public void withdraw_money() {

    }

    @Override
    public void transfer_money() {

    }

    @Override
    public void calculate_amount() {

    }
}
