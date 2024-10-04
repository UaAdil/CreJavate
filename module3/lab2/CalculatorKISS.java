package Modules.module3.lab2;

class Calculator {
    public void Add(int a, int b) {
        System.out.println(a + b);
    }
    public void Subtract(int a, int b) {
        System.out.println(a - b);
    }
    public void Multiply(int a, int b) {
        System.out.println(a * b);
    }
    public void Divide(int a, int b) {
        if (b != 0) {
            System.out.println(a / b);
        } else {
            System.out.println("Cannot divide by zero");
        }
    }
}

public class CalculatorKISS {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.Add(2,22);
        calculator.Subtract(15, 12);
        calculator.Divide(50, 5);
    }
}