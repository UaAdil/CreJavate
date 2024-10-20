package Modules.module7.practice6;
import java.util.Scanner;
class TravelBookingContext {
    private ICostCalculate strategy;

    public void setCostCalculation(ICostCalculate strategy) {
        this.strategy = strategy;
    }

    public double calculateCost(double distance, int passengers, String serviceClass, boolean hasDiscount) {
        if (strategy == null) {
            throw new IllegalStateException("The cost calculation strategy has not been selected!v");
        }
        return strategy.calculateCost(distance, passengers, serviceClass, hasDiscount);
    }
}



public class TravelTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelBookingContext bookingContext = new TravelBookingContext();

        System.out.println("Choose transport type: 1-Airplane, 2-Train, 3-Bus, 4-VIP-Transport");
        int transportChoice = scanner.nextInt();

        switch (transportChoice) {
            case 1:
                bookingContext.setCostCalculation(new AirplaneCostCalculation());
                break;
            case 2:
                bookingContext.setCostCalculation(new TrainCostCalculation());
                break;
            case 3:
                bookingContext.setCostCalculation(new BusCostCalculation());
                break;
            case 4:
                bookingContext.setCostCalculation(new VipTransportCostCalculation());
                break;
            default:
                System.out.println("Invalid transport choice.");
                return;
        }

        System.out.println("Enter distance (in kilometers): ");
        double distance = scanner.nextDouble();

        System.out.println("Enter number of passengers: ");
        int passengers = scanner.nextInt();

        System.out.println("Choose service class: economy or business");
        String serviceClass = scanner.next();

        System.out.println("Is there a discount? (true/false)");
        boolean hasDiscount = scanner.nextBoolean();

        try {
            double cost = bookingContext.calculateCost(distance, passengers, serviceClass, hasDiscount);
            System.out.printf("Trip cost: %.2f%n", cost);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
