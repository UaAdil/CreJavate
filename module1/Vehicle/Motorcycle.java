package Modules.module1.Vehicle;

public class Motorcycle extends Vehicle {
    private String bodyType;
    private boolean hasSidecar;

    public Motorcycle(String make, String model, int year, String bodyType, boolean hasSidecar) {
        super(make, model, year);
        this.bodyType = bodyType;
        this.hasSidecar = hasSidecar;
    }

    public String getBodyType() {
        return bodyType;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    @Override
    public String toString() {
        return super.toString() + ", Motorcycle [BodyType=" + bodyType + ", HasSidecar=" + hasSidecar + "]";
    }
}
