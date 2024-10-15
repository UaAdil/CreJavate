package Modules.module4.homework3;

class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}

public interface SalaryCalculator {
    double calculateSalary(Employee employee);
}


class Permanent implements SalaryCalculator {
    @Override
    public double calculateSalary(Employee employee) {
        return employee.getBaseSalary() * 1.2; // 20% bonus
    }
}

class Contract implements SalaryCalculator {
    @Override
    public double calculateSalary(Employee employee) {
        return employee.getBaseSalary() * 1.1; // 10% bonus
    }
}

class Intern implements SalaryCalculator {
    @Override
    public double calculateSalary(Employee employee) {
        return employee.getBaseSalary() * 0.8; // 80% from salary
    }
}

class Freelancer implements SalaryCalculator {
    @Override
    public double calculateSalary(Employee employee) {
        return employee.getBaseSalary() * 1.3; // 30% bonus
    }
}


