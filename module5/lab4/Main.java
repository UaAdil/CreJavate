package Modules.module5.lab4;

import java.util.Scanner;

class CarFactory extends TransportFactory {
    @Override
    public Transport CreateTransport(String model, int speed) {
        return new Car(model, speed);
    }
}

class MotorcycleFactory extends TransportFactory {
    @Override
    public Transport CreateTransport(String model, int speed) {
        return new Motorcycle(model, speed);
    }
}

class PlaneFactory extends TransportFactory {
    @Override
    public Transport CreateTransport(String model, int speed) {
        return new Plane(model, speed);
    }
}

class MetroFactory extends TransportFactory {
    @Override
    public Transport CreateTransport(String model, int speed) {
        return new Metro(model, speed);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of transport (car, motorcycle, plane, metro): ");
        String transportType = scanner.nextLine().toLowerCase();

        System.out.println("Enter the model of the transport: ");
        String model = scanner.nextLine();

        System.out.println("Enter the speed of the transport: ");
        int speed = scanner.nextInt();

        TransportFactory factory = null;

        // Factory selection depending on the type of transport
        switch (transportType) {
            case "car":
                factory = new CarFactory();
                break;
            case "motorcycle":
                factory = new MotorcycleFactory();
                break;
            case "plane":
                factory = new PlaneFactory();
                break;
            case "metro":
                factory = new MetroFactory();
                break;
            default:
                System.out.println("Invalid transport type.");
                return;
        }

        // Create a transport and perform its moves
        Transport transport = factory.CreateTransport(model, speed);
        transport.Move();
        transport.FuelUp();
    }
}
