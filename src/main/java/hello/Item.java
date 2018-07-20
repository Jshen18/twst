package hello;

public class Item {
    private final String[] IMPORTED_CHECK = new String[]{"imported"};
    private final String[] EXEMPTIONS_CHECK = new String[]{"book", "pill", "chocolate" };


    private int quantity;
    private String name;
    private float basePrice;
    private float salesTax;

    public Item(int quantity, String name, float basePrice) {
        this.quantity = quantity;
        this.name = name;
        this.basePrice = basePrice;

    }

    @Override
    public String toString() {
        return name;
    }

    public float getBasePrice() {
        return this.basePrice;
    }

    public float getSalesTax() {
        return this.salesTax;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getName() { return this.name; }

    public boolean isImported() {
        for(String check : IMPORTED_CHECK) {
            if (this.name.contains(check)) {
                return true;
            }
        }
        return false;
    }
    public boolean isExempt() {
        for(String check : EXEMPTIONS_CHECK) {
            if (this.name.contains(check)) {
                return true;
            }
        }
        return false;
    }
    public void setSalesTax(float salesTax) {
        this.salesTax = salesTax;
    }

}
