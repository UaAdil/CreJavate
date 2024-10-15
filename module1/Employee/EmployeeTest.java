package Modules.module1.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee worker1 = new Worker("Adil Khan", 101, "Worker", 20.0, 160);
        Employee manager1 = new Manager("Uali Khan", 102, "Manager", 3000.0, 400.0);

        System.out.println(worker1);
        System.out.println("Salary: " + worker1.calculateSalary());

        System.out.println(manager1);
        System.out.println("Salary: " + manager1.calculateSalary());
    }
}

