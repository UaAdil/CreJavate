package Modules.module1.Employee;

public class Employee {
    protected String name;
    protected int id;
    protected String position;

    public Employee(String name, int id, String position) {
        this.name = name;
        this.id = id;
        this.position = position;
    }

    public double calculateSalary() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", position='" + position + '\'' +
                '}';
    }
}

class Worker extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Worker(String name, int id, String position, double hourlyRate, int hoursWorked) {
        super(name, id, position);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", hourlyRate=" + hourlyRate +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}

class Manager extends Employee {
    private double fixedSalary;
    private double bonus;

    public Manager(String name, int id, String position, double fixedSalary, double bonus) {
        super(name, id, position);
        this.fixedSalary = fixedSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return fixedSalary + bonus;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", fixedSalary=" + fixedSalary +
                ", bonus=" + bonus +
                '}';
    }
}
