package Modules.module4.practice3;

import java.util.ArrayList;
import java.util.List;

class Order {
    private List<OrderItem> items;
    private IPayment paymentMethod;
    private IDelivery deliveryMethod;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(String productName, int quantity, double price) {
        items.add(new OrderItem(productName, quantity, price));
    }

    public double calculateTotal(DiscountCalculator discountCalculator) {
        double total = items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        return discountCalculator.calculateDiscount(total);
    }

    public void setPaymentMethod(IPayment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDeliveryMethod(IDelivery deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void processOrder() {
        if (paymentMethod != null) {
            paymentMethod.processPayment(calculateTotal(new DiscountCalculator()));
        }
        if (deliveryMethod != null) {
            deliveryMethod.deliverOrder(this);
        }
    }
}

class OrderItem {
    private String productName;
    private int quantity;
    private double price;

    public OrderItem(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }
}

class DiscountCalculator {
    public double calculateDiscount(double total) {
        return total * 0.9;
    }
}

public class OrderMain {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem("Item 1", 2, 100);
        order.addItem("Item 2", 1, 200);

        order.setPaymentMethod(new CreditCardPayment());
        order.setDeliveryMethod(new CourierDelivery());

        order.processOrder();

        INotification notification = new EmailNotification();
        notification.sendNotification("Your order has been successfully processed!");
    }
}

