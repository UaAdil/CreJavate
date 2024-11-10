package Modules.module10.practice9;

import java.util.List;
import java.util.ArrayList;

abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract void display(int depth);

    public abstract int getBudget();

    public abstract int getEmployeeCount();

    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add.");
    }

    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove.");
    }

    public void setSalary(int salary) {
        throw new UnsupportedOperationException("Operation is none.");
    }
}

class Employee extends OrganizationComponent {
    private String position;
    private int salary;

    public Employee(String name, String position, int salary) {
        super(name);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void display(int depth) {
        System.out.println(" ".repeat(depth) + "- " + position + ": " + name + " (Salary: " + salary + ")");
    }

    @Override
    public int getBudget() {
        return salary;
    }

    @Override
    public int getEmployeeCount() {
        return 1;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }
}

class Department extends OrganizationComponent {
    private List<OrganizationComponent> members = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void display(int depth) {
        System.out.println(" ".repeat(depth) + "+ Department: " + name);
        for (OrganizationComponent member : members) {
            member.display(depth + 2);
        }
    }

    @Override
    public int getBudget() {
        int wholeBudget = 0;
        for (OrganizationComponent member : members) {
            wholeBudget += member.getBudget();
        }
        return wholeBudget;
    }

    @Override
    public int getEmployeeCount() {
        int allEmployees = 0;
        for (OrganizationComponent member : members) {
            allEmployees += member.getEmployeeCount();
        }
        return allEmployees;
    }

    @Override
    public void add(OrganizationComponent component) {
        members.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        members.remove(component);
    }
}


public class Organization {
    public static void main(String[] args) {
        Department mainDepartment = new Department("Head Office");

        Department hrDepartment = new Department("HR Department");
        hrDepartment.add(new Employee("Karina", "Head HR Manager", 5000));
        hrDepartment.add(new Employee("Kulimkas", "HR Manager", 3000));

        Department marketingDepartment = new Department("Marketing Department");
        marketingDepartment.add(new Employee("Damir", "Actor", 7000));
        marketingDepartment.add(new Employee("Tayir", "Operator", 6000));
        marketingDepartment.add(new Employee("Aruna", "SMM", 5000));

        Department financeDepartment = new Department("Finance Department");
        financeDepartment.add(new Employee("Abzal", "Financier", 8000));
        financeDepartment.add(new Employee("Nurs", "Financier's assistant", 6000));

        mainDepartment.add(hrDepartment);
        mainDepartment.add(marketingDepartment);
        mainDepartment.add(financeDepartment);

        mainDepartment.display(1);
        System.out.println("Total Budget: " + mainDepartment.getBudget());
        System.out.println("Total Employees: " + mainDepartment.getEmployeeCount());
    }
}
