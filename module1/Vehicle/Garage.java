package Modules.module1.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Vehicle> vehicles;

    public Garage() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println(vehicle + " added into the garage");
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove((vehicle));
        System.out.println(vehicle + " removed from garage");
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public String toString() {
        return "Garage [Vehicles =" + vehicles + "]";
    }
}
