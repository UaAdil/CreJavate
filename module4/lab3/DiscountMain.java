package Modules.module4.lab3;

class DiscountCalculator {
    public double calculateDiscount(DiscountStrategy discountStrategy, double amount) {
        return discountStrategy.calculateDiscount(amount);
    }
}

public class DiscountMain {
    public static void main(String[] args) {
        DiscountCalculator discountCalculator = new DiscountCalculator();

        double amount = 100.0;
        System.out.println("Regular Customer: " + discountCalculator.calculateDiscount(new RegularCustomerDiscount(), amount));
        System.out.println("Silver Customer: " + discountCalculator.calculateDiscount(new SilverCustomerDiscount(), amount));
        System.out.println("Gold Customer: " + discountCalculator.calculateDiscount(new GoldCustomerDiscount(), amount));
        System.out.println("Platinum Customer: " + discountCalculator.calculateDiscount(new PlatinumCustomerDiscount(), amount));
    }
}

