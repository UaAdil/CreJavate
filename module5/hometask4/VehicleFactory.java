package Modules.module5.hometask4;

public abstract class VehicleFactory {
    public abstract IVehicle CreateVehicle();
}

class CarFactory extends VehicleFactory {
    private String brand;
    private String model;
    private String fuelType;

    public CarFactory(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    @Override
    public IVehicle CreateVehicle() {
        return new Car(brand, model, fuelType);
    }
}

class MotorcycleFactory extends VehicleFactory {
    private String type;
    private int engineCapacity;

    public MotorcycleFactory(String type, int engineCapacity) {
        this.type = type;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public IVehicle CreateVehicle() {
        return new Motorcycle(type, engineCapacity);
    }
}

class TruckFactory extends VehicleFactory {
    private int loadCapacity;
    private int numberOfAxles;

    public TruckFactory(int loadCapacity, int numberOfAxles) {
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
    }

    @Override
    public IVehicle CreateVehicle() {
        return new Truck(loadCapacity, numberOfAxles);
    }
}

class BusFactory extends VehicleFactory {
    private int passengerCapacity;

    public BusFactory(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public IVehicle CreateVehicle() {
        return new Bus(passengerCapacity);
    }
}
