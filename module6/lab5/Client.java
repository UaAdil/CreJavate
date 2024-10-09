package Modules.module6.lab5;

public class Client {
    public static void main(String[] args) {
        // create officeBuilder computer
        IComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector director = new ComputerDirector(officeBuilder);
        director.constructComputer();
        Computer officeComputer = director.getComputer();
        System.out.println("Office Computer: " + officeComputer);

        // create gamingBuilder computer
        IComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director = new ComputerDirector(gamingBuilder);
        director.constructComputer();
        Computer gamingComputer = director.getComputer();
        System.out.println("Gaming Computer: " + gamingComputer);

        // create serverBuilder computer
        IComputerBuilder serverBuilder = new ServerComputerBuilder();
        director = new ComputerDirector(serverBuilder);
        director.constructComputer();
        Computer serverComputer = director.getComputer();
        System.out.println("Server Computer: " + serverComputer);
    }
}

