package Modules.module1.Vehicle;

public class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }
    public String getMake() {
        return make;
    }
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Modules.module1.Vehicle [Make=" + make + ", Model=" + model + ", Year=" + year + "]";
    }
}
