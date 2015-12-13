package week04.ShopInventory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgipavlov on 13.12.15.
 */
public class Order {
    public class Innner{
        int id;
        int quantity;

        public Innner(int id, int quantity) {
            this.id = id;
            this.quantity = quantity;
        }
        public int getId() {
            return id;
        }
        public int getQuantity() {
            return quantity;
        }
    }

    public Order() {
        this.list = new ArrayList<>();
    }

    private List<Innner> list;

    public List<Innner> getList() {
        return list;
    }

    public void setList(List<Innner> list) {
        this.list = list;
    }

    private void setOrder(int id,int quantity){
        Innner innner = new Innner(id,quantity);
        list.add(innner);
    }
}
