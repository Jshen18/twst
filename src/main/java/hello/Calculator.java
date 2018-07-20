package hello;

import java.util.List;

public class Calculator {
    private static final int IMPORTED_TAX_RATE = 5;
    private static final int NON_EXEMPT_TAX_RATE = 10;

    public static float calculateSalesTax(Item item) {
        int tax = 0;
        if (item.isImported()) {
            tax += IMPORTED_TAX_RATE;
        }
        if (!item.isExempt()) {
            tax += NON_EXEMPT_TAX_RATE;
        }
        float salesTax = (item.getBasePrice() * tax * item.getQuantity()) / 100;
        return roundNumber(salesTax);
    }

    public static float roundNumber(float num) {
        return (float) Math.ceil(num * 20) /20;
    }

    public static float calculateSalesTaxes(List<Item> items) {
       float salesTaxes = 0;
       for(Item item: items) {
           salesTaxes += item.getSalesTax();
       }
       return salesTaxes;
    }

    public static float calculateTotal(List<Item> items) {
        float total = 0;
        for(Item item: items) {
            total += item.getBasePrice() + item.getSalesTax();
        }
    return total;
    }
}
