package week04.VATTAXcalculator;

/**
 * Created by georgipavlov on 13.12.15.
 */
public class CalculatorTax {
    final int  countryId;
    final double VATTax;
    final  boolean IsDefault;


    public CalculatorTax(int countryId, double VATTax,
                         boolean isDefault) {
        this.countryId = countryId;
        this.VATTax = VATTax;
        IsDefault = isDefault;
    }

    public int getCountryId() {
        return countryId;
    }

    public double getVATTax() {
        return VATTax;
    }

    public boolean isDefault() {
        return IsDefault;
    }
}
