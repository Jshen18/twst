package hello;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloWorld {
  public static void main(String[] args) throws IOException {
    FileParser fileParser = new FileParser(args);
    Printer printer = new Printer(fileParser);
    printer.printReceipt();

    for (String file : args) {
      List<String> lines = Files.readAllLines(new File(file).toPath());
      List<Item> allItems = new ArrayList<>();

      for (String line : lines) {
        String[] splitLine = line.split(" ");
        int quantity = Integer.parseInt(splitLine[0]);
        String name = String.join(" ", Arrays.copyOfRange(splitLine, 1, splitLine.length - 2));
        float basePrice = Float.parseFloat(splitLine[splitLine.length - 1]);
        Item item = new Item(quantity, name, basePrice);
        float tax = Calculator.calculateSalesTax(item);
        item.setSalesTax(tax);
        allItems.add(item);
      }
      // ... PRINTER

    }
  }
}





