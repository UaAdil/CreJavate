package Modules.module4.practice3;

interface IPayment {
    void processPayment(double amount);
}

class CreditCardPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment by card for the amount of: " + amount);
    }
}

class PayPalPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment via PayPal for the amount: " + amount);
    }
}

class BankTransferPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Bank transfer for the amount of: " + amount);
    }
}
