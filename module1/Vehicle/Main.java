package Modules.module1.Vehicle;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2021, 4, "Automatic");
        Car car2 = new Car("Hyandai", "Sonata", 2023, 4, "Manual");
        Motorcycle moto1 = new Motorcycle("Yamaha", "MT-07", 2021, "Sport", false);
        // Create garage
        Garage garage1 = new Garage();
        Garage garage2 = new Garage();
        // adding vehicles
        garage1.addVehicle(car1);
        garage1.addVehicle(moto1);
        garage2.addVehicle(car2);
        // create fleet
        Fleet fleet = new Fleet();
        fleet.addGarage(garage1);
        fleet.addGarage(garage2);
        // searching cars by mark
        System.out.println("Search for Hyandai brand vehicles:");
        List<Vehicle> foundVehicles = fleet.searchVehicles("Hyandai");
        for (Vehicle vehicle : foundVehicles) {
            System.out.println(vehicle);
        }

        // remove vehicle
        garage1.removeVehicle(car1);
        // remove garage from fleet
        fleet.removeGarage(garage2);
    }
}
