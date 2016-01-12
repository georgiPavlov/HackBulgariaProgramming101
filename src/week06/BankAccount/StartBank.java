package week06.BankAccount;

/**
 * Created by georgipavlov on 10.01.16.
 */
public class StartBank {
    TheBank bank;

    public StartBank() {
        this.bank = new TheBank();

    }

    public void createBankAccount(){
        try {
            bank.create_bank_account();
        } catch (BankExeption bankExeption) {
            bankExeption.getMessage();
            bankExeption.printStackTrace();
        }
    }
    public void showHistory(){
        bank.show_history();
    }
    public void withdraw_money(){
        try {
            bank.withdraw_money();
        } catch (InsufficientFundsException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (BankExeption bankExeption) {
            bankExeption.getMessage();
            bankExeption.printStackTrace();
        }
    }
    public void transfer_money(){
        try {
            bank.transfer_money();
        } catch (BankExeption bankExeption) {
            bankExeption.getMessage();
            bankExeption.printStackTrace();
        } catch (InsufficientFundsException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
    public void calculate_amount(){
        try {
            bank.calculate_amount();
        } catch (BankExeption bankExeption) {
            bankExeption.getMessage();
            bankExeption.printStackTrace();
        }
    }

    public  void logIn(){
        try {
            bank.logIn();
        } catch (BankExeption bankExeption) {
            bankExeption.getMessage();
            bankExeption.printStackTrace();
        }
    }

    public void backUP(){
        bank.backUp();
    }



}
