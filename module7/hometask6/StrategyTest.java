package Modules.module7.hometask6;

interface IPaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.printf("Paid %.2f using Credit Card.%n", amount);
    }
}

class PayPalPayment implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.printf("Paid %.2f using PayPal.%n", amount);
    }
}

class CryptocurrencyPayment implements IPaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.printf("Paid %.2f using Cryptocurrency.%n", amount);
    }
}

class PaymentContext {
    private IPaymentStrategy paymentStrategy;

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("Payment strategy not set.");
        }
    }
}

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // chose payment method
        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.executePayment(150.00);

        // switch to paypal
        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.executePayment(200.00);

        // switch to crypto
        paymentContext.setPaymentStrategy(new CryptocurrencyPayment());
        paymentContext.executePayment(300.00);
    }
}
