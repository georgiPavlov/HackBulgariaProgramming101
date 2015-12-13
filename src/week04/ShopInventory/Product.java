package week04.ShopInventory;

import week04.VATTAXcalculator.NotSupportedCountryException;
import week04.VATTAXcalculator.VATTaxCalculator;

/**
 * Created by georgipavlov on 13.12.15.
 */
public class Product {
    private double beforeTaxPrice;
    private double afterTaxPrice;
    private int idCountry;
    private String name;
    private int  quantity;
    private int id;
    public static VATTaxCalculator vatCalc=null;

    public Product(double beforeTaxPrice, int idCountry,
                   String name, int quantity, int id) throws NotSupportedCountryException {
        this.beforeTaxPrice = beforeTaxPrice;
        this.idCountry = idCountry;
        if(vatCalc == null){
            throw new NotSupportedCountryException("VATTaxCalculator is not add");
        }
        this.afterTaxPrice = vatCalc.CalculateTax(
                beforeTaxPrice,idCountry) + beforeTaxPrice;
        this.name = name;
        this.quantity = quantity;
        this.id = id;
    }


    public Product(double beforeTaxPrice, int idCountry,
                   String name, int quantity, int id,VATTaxCalculator t) throws NotSupportedCountryException {
        this.beforeTaxPrice = beforeTaxPrice;
        this.idCountry = idCountry;
        vatCalc=t;
        this.afterTaxPrice = vatCalc.CalculateTax(
                beforeTaxPrice,idCountry) + beforeTaxPrice;
        this.name = name;
        this.quantity = quantity;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getBeforeTaxPrice() {
        return beforeTaxPrice;
    }

    public double getAfterTaxPrice() {
        return afterTaxPrice;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
