package Modules.module4.homework3;

public class SalaryCalculatorTest {
    public static void main(String[] args) {
        Employee permanentEmployee = new Employee("Ualikhan", 3000);
        Employee contractEmployee = new Employee("Umar", 2500);
        Employee intern = new Employee("Djoni", 1000);
        Employee freelancer = new Employee("Qanat", 2000);

        SalaryCalculator permanentCalculator = new Permanent();
        SalaryCalculator contractCalculator = new Contract();
        SalaryCalculator internCalculator = new Intern();
        SalaryCalculator freelancerCalculator = new Freelancer();

        // result
        System.out.println("Permanent Employee Salary: " + permanentCalculator.calculateSalary(permanentEmployee));
        System.out.println("Contract Employee Salary: " + contractCalculator.calculateSalary(contractEmployee));
        System.out.println("Intern Salary: " + internCalculator.calculateSalary(intern));
        System.out.println("Freelancer Salary: " + freelancerCalculator.calculateSalary(freelancer));
    }
}
