package Modules.module4.homework3;

public class Order {
    private String productName;
    private int quantity;
    private double price;

    public Order(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}


class PriceCalculator {
    public double calculateTotalPrice(Order order) {
        return order.getQuantity() * order.getPrice() * 0.9; // 10% sale
    }
}

class PaymentProcessor {
    public void processPayment(Order order, String paymentDetails) {
        System.out.println("Payment for " + order.getProductName() + " processed using: " + paymentDetails);
    }
}

class EmailService {
    public void sendConfirmationEmail(String email) {
        System.out.println("Confirmation email sent to: " + email);
    }
}



