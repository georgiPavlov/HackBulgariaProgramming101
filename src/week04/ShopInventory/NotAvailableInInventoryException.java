package week04.ShopInventory;

/**
 * Created by georgipavlov on 13.12.15.
 */
public class NotAvailableInInventoryException extends Exception {
    public NotAvailableInInventoryException(String message){
        super(message);
    }
}
