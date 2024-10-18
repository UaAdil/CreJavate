package Modules.module7.lab6;

import java.util.Scanner;

class DeliveryContext {
    private IShipping shipping;

    // Установка стратегии доставки
    public void setShippingStrategy(IShipping strategy) {
        this.shipping= strategy;
    }

    // Расчет стоимости доставки
    public double calculateCost(double weight, double distance) {
        if (shipping == null) {
            throw new IllegalStateException("The delivery strategy has not been set.");
        }
        return shipping.calculateShippingCost(weight, distance);
    }
}

public class ShippingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeliveryContext deliveryContext = new DeliveryContext();

        System.out.println("Choose the type of delivery: 1 - Standard, 2 - Express, 3 - International");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                deliveryContext.setShippingStrategy(new StandardShipping());
                break;
            case "2":
                deliveryContext.setShippingStrategy(new ExpressShipping());
                break;
            case "3":
                deliveryContext.setShippingStrategy(new InternationalShipping());
                break;
            case "4":
                deliveryContext.setShippingStrategy(new NightShipping());
                break;

            default:
                System.out.println("Wrong chosen.");
                return;
        }

        System.out.println("Enter the package weight (kg):");
        double weight = scanner.nextDouble();

        System.out.println("Enter the delivery distance (km):");
        double distance = scanner.nextDouble();

        if (weight < 0 || distance < 0) {
            System.out.println("The weight and distance must be positive.");
            return;
        }

        double cost = deliveryContext.calculateCost(weight, distance);
        System.out.printf("The cost of delivery: %.2f\n", cost);
    }
}
