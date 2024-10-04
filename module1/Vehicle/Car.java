package Modules.module1.Vehicle;
public class Car extends Vehicle {
    private int numberOfDoors;
    private String transmissionType;

    public Car(String make, String model, int year, int numberOfDoors, String transmissionType) {
        super(make, model, year);
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    @Override
    public String toString() {
        return super.toString() + ", Car [Doors=" + numberOfDoors + ", Transmission=" + transmissionType + "]";
    }
}
