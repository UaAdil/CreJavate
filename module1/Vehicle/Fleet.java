package Modules.module1.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Garage> garages;

    public Fleet() {
        garages = new ArrayList<>();
    }

    // add garage
    public void addGarage(Garage garage) {
        garages.add(garage);
        System.out.println("The garage was added into fleet.");
    }

    // remove garage
    public void removeGarage(Garage garage) {
        garages.remove(garage);
        System.out.println("The garage was removed from fleet.");
    }

    // searching by vehicles
    public List<Vehicle> searchVehicles(String make) {
        List<Vehicle> result = new ArrayList<>();
        for (Garage garage : garages) {
            for (Vehicle vehicle : garage.getVehicles()) {
                if (vehicle.getMake().equalsIgnoreCase(make)) {
                    result.add(vehicle);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Fleet [Garages=" + garages + "]";
    }
}
