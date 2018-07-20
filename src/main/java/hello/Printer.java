package hello;

import java.util.List;

public class Printer {
  private FileParser fileParser;

  public Printer(FileParser fileParser) {
    this.fileParser = fileParser;
  }

  public void printReceipt() {
    List<Item> items = this.fileParser.getItems();

    float salesTaxes = Calculator.calculateSalesTaxes(items);
    float total = Calculator.calculateTotal(items);

    for (Item item : items) {
      int quantity = item.getQuantity();
      String name = item.getName();
      float priceWithTax = item.getBasePrice() + item.getSalesTax();
      System.out.println(String.format("%d %s: %.2f", quantity, name, priceWithTax));
    }
    System.out.println(String.format("Sales Taxes: %.2f", salesTaxes));
    System.out.println(String.format("Total: %.2f\n", total));
  }

}
