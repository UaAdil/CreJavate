package Modules.module5.lab4;

public interface Transport {
    void Move();
    void FuelUp();
}

class Car implements Transport {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public void Move() {
        System.out.println("The car " + model + " is moving at " + speed + " km/h.");
    }

    @Override
    public void FuelUp() {
        System.out.println("Filling up the car " + model + " with gasoline.");
    }
}

class Motorcycle implements Transport {
    private String model;
    private int speed;

    public Motorcycle(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public void Move() {
        System.out.println("The motorcycle " + model + " is moving at " + speed + " km/h.");
    }

    @Override
    public void FuelUp() {
        System.out.println("Filling up the motorcycle " + model + " with gasoline.");
    }
}

class Plane implements Transport {
    private String model;
    private int speed;

    public Plane(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public void Move() {
        System.out.println("The plane " + model + " is flying at " + speed + " km/h.");
    }

    @Override
    public void FuelUp() {
        System.out.println("Filling up the plane " + model + " with jet fuel.");
    }
}

class Metro implements Transport {
    private String model;
    private int speed;

    public Metro(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public void Move() {
        System.out.println("The metro " + model + " is moving at " + speed + " km/h.");
    }

    @Override
    public void FuelUp() {
        System.out.println("The metro " + model + " is charging electricity.");
    }
}

