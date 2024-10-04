package Modules.module4.lab3;

public interface DiscountStrategy {
    double calculateDiscount(double amount);
}

class RegularCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount; // 0%
    }
}
class SilverCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.9; // 10%
    }
}
class GoldCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.8; // 20%
    }
}

class PlatinumCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.7; // 30%
    }
}
