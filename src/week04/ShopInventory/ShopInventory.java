package week04.ShopInventory;

import java.util.List;

/**
 * Created by georgipavlov on 13.12.15.
 */
public class ShopInventory {
    List<Product> products;

    public ShopInventory(List<Product> products) {
        this.products = products;
    }

    public double Audit(){
        double auditResult=0;
        for (int i = 0; i <products.size() ; i++) {
           auditResult += products.get(i).getAfterTaxPrice();
        }
        return auditResult;
    }

    public double RequestOrder(Order order) throws NotAvailableInInventoryException {
        boolean tr;
        int amout=0;

        for (int i = 0; i < order.getList().size() ; i++) {
            tr=false;
            p:for (int j = 0; j < products.size(); j++) {
                if(order.getList().get(i).getId() == products.get(j).getId()){
                    if( products.get(j).getQuantity() - order.getList().get(i).getQuantity() > 0 ){
                        amout +=order.getList().get(i).getQuantity();
                        tr=true;
                        break p;
                    }
                }
            }
            if(!tr){
              throw  new  NotAvailableInInventoryException("id cant be found or not not enough Quantity!");
            }

        }
        return amout;

    }

}
