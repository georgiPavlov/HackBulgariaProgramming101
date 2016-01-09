package week06.BankAccount;

/**
 * Created by georgipavlov on 09.01.16.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
