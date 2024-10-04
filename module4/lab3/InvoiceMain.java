package Modules.module4.lab3;

import java.util.ArrayList;
import java.util.List;

class Invoice {
    private int id;
    private List<Item> items;
    private double taxRate;

    public Invoice(int id, List<Item> items, double taxRate) {
        this.id = id;
        this.items = items;
        this.taxRate = taxRate;
    }

    public int getId() {
        return id;
    }
    public List<Item> getItems() {
        return items;
    }

    public double getTaxRate() {
        return taxRate;
    }
}

class InvoiceCalculator {
    // Method for calculate total;
    public double calculateTotal(Invoice invoice) {
        double subTotal = 0;
        for (Item item : invoice.getItems()) {
            subTotal += item.getPrice();
        }
        return subTotal + (subTotal * invoice.getTaxRate());
    }
}

class InvoiceRepository {
    public void saveToDatabase(Invoice invoice) {
        System.out.println("Saving invoice with ID " + invoice.getId() + " to the database.");
    }
}
class Item {
    private String name;
    private double price;
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}

public class InvoiceMain {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", 10.0));
        items.add(new Item("Item 2", 15.0));

        Invoice invoice = new Invoice(1, items, 0.2);  // 20% tax

        InvoiceCalculator calculator = new InvoiceCalculator();
        double total = calculator.calculateTotal(invoice);
        System.out.println("Total invoice amount: " + total);

        InvoiceRepository repository = new InvoiceRepository();
        repository.saveToDatabase(invoice);
    }
}
