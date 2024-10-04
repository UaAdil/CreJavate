package Modules.module3.lab2;
public class OrderService {

    private void processOrder(String action, String productName, int quantity, double price) {
        double totalPrice = calculateTotalPrice(quantity, price);
        System.out.println("Order for " + productName + " " + action + ". Total: " + totalPrice);
    }

    public void createOrder(String productName, int quantity, double price) {
        processOrder("created", productName, quantity, price);
    }

    public void updateOrder(String productName, int quantity, double price) {
        processOrder("updated", productName, quantity, price);
    }

    private double calculateTotalPrice(int quantity, double price) {
        return quantity * price;
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.createOrder("Laptop", 2, 999.99);
        orderService.updateOrder("MacBook", 4, 1599.99);
    }
}
