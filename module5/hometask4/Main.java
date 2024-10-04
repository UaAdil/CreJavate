package Modules.module5.hometask4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select vehicle type (car, motorcycle, truck, bus): ");
        String vehicleType = scanner.nextLine().toLowerCase();
        VehicleFactory factory = null;

        switch (vehicleType) {
            case "car":
                System.out.println("Enter car brand: ");
                String brand = scanner.nextLine();
                System.out.println("Enter car model: ");
                String model = scanner.nextLine();
                System.out.println("Enter fuel type: ");
                String fuelType = scanner.nextLine();
                factory = new CarFactory(brand, model, fuelType);
                break;
            case "motorcycle":
                System.out.println("Enter motorcycle type: ");
                String type = scanner.nextLine();
                System.out.println("Enter engine capacity: ");
                int engineCapacity = scanner.nextInt();
                factory = new MotorcycleFactory(type, engineCapacity);
                break;
            case "truck":
                System.out.println("Enter truck load capacity: ");
                int loadCapacity = scanner.nextInt();
                System.out.println("Enter number of axles: ");
                int numberOfAxles = scanner.nextInt();
                factory = new TruckFactory(loadCapacity, numberOfAxles);
                break;
            case "bus":
                System.out.println("Enter bus passenger capacity: ");
                int passengerCapacity = scanner.nextInt();
                factory = new BusFactory(passengerCapacity);
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        IVehicle vehicle = factory.CreateVehicle();
        vehicle.Drive();
        vehicle.Refuel();
    }
}
