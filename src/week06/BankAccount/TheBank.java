package week06.BankAccount;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by georgipavlov on 08.01.16.
 */
public class TheBank implements CLI {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
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
    private static final String INTEREST = "^[0-9.]{3,15}$";
    private static final String USERNAME_PATTERN = "^[a-zA-z]{3,15}$";
    private static final String USERNAME_PATTERN = "^[a-zA-z]{3,15}$";




    @Override
    public void create_bank_account() {
        Scanner scanner = new Scanner(System.in);
        String res;

        System.out.println("Enter first name");
        res = scanner.nextLine();



    }

    @Override
    public void show_history() {

    }

    @Override
    public void add_money() {

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
