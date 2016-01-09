package week06.BankAccount;

/**
 * Created by georgipavlov on 08.01.16.
 */
public interface CLI {
    void create_bank_account() throws BankExeption;
    void show_history();
    void add_money() throws BankExeption;
    void withdraw_money() throws InsufficientFundsException, BankExeption;
    void transfer_money() throws BankExeption, InsufficientFundsException;
    void calculate_amount() throws BankExeption;
}
