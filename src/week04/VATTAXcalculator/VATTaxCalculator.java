package week04.VATTAXcalculator;

import java.util.List;

/**
 * Created by georgipavlov on 13.12.15.
 */
public class VATTaxCalculator {
    List<CalculatorTax> taxes;

    public VATTaxCalculator(List<CalculatorTax> taxes) {
        this.taxes = taxes;
    }


    public double CalculateTax (double price,int id) throws NotSupportedCountryException {
        CalculatorTax temp ;
        double tax = 0;
        for (int i = 0; i <taxes.size() ; i++) {
            temp= taxes.get(i);
            if(temp.getCountryId() == id){
                tax = price*temp.getVATTax()/100;
                return  tax;
            }
        }
        throw new NotSupportedCountryException("id not found");
    }

    public double CalculateTax (double price){
        CalculatorTax temp ;
        double tax = 0;
        for (int i = 0; i <taxes.size() ; i++) {
            temp= taxes.get(i);
            if(temp.isDefault()){
                tax = price*temp.getVATTax()/100;
            }
        }
        return  tax;
    }
}
