package Modules.module5.hometask4;

public interface IVehicle {
    void Drive();
    void Refuel();
}

class Car implements IVehicle {
    private String brand;
    private String model;
    private String fuelType;

    public Car(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public void Drive() {
        System.out.println("The car " + brand + " " + model + " is driving.");
    }

    @Override
    public void Refuel() {
        System.out.println("Refueling the car " + brand + " " + model + " with " + fuelType + ".");
    }
}

class Motorcycle implements IVehicle {
    private String type;
    private int engineCapacity;

    public Motorcycle(String type, int engineCapacity) {
        this.type = type;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void Drive() {
        System.out.println("The " + type + " motorcycle with engine capacity " + engineCapacity + "cc is driving.");
    }

    @Override
    public void Refuel() {
        System.out.println("Refueling the motorcycle with gasoline.");
    }
}

class Truck implements IVehicle {
    private int loadCapacity;
    private int numberOfAxles;

    public Truck(int loadCapacity, int numberOfAxles) {
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
    }

    @Override
    public void Drive() {
        System.out.println("The truck with load capacity " + loadCapacity + " tons and " + numberOfAxles + " axles is driving.");
    }

    @Override
    public void Refuel() {
        System.out.println("Refueling the truck with diesel.");
    }
}

class Bus implements IVehicle {
    private int passengerCapacity;

    public Bus(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void Drive() {
        System.out.println("The bus with capacity of " + passengerCapacity + " passengers is driving.");
    }

    @Override
    public void Refuel() {
        System.out.println("Refueling the bus with diesel.");
    }
}

