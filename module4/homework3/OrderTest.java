package Modules.module4.homework3;

public class OrderTest {
    public static void main(String[] args) {
        // create new order
        Order order = new Order("Laptop", 2, 1200.00);

        // calculate total price
        PriceCalculator priceCalculator = new PriceCalculator();
        double totalPrice = priceCalculator.calculateTotalPrice(order);
        System.out.println("Total Price: " + totalPrice);

        // payment process
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(order, "Credit Card");

        // send confirmation to email
        EmailService emailService = new EmailService();
        emailService.sendConfirmationEmail("customer@example.com");
    }
}
