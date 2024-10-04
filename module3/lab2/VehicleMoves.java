package Modules.module3.lab2;
class Vehicle {
    public void Start() {
        System.out.println("Modules.module1.Vehicle is starting");
    }
    public void Stop() {
        System.out.println("Modules.module1.Vehicle is stopping");
    }
}
class Car extends Vehicle {
}

class Truck extends Vehicle {
}

public class VehicleMoves {
    public static void main(String[] args) {
        Car car = new Car();
        Truck truck = new Truck();

        System.out.println("Car actions:");
        car.Start();
        car.Stop();

        System.out.println("\nTruck actions:");
        truck.Start();
        truck.Stop();
    }
}
