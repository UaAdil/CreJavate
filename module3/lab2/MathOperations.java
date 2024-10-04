package Modules.module3.lab2;

class Operations {
    public int Add(int a, int b) {
        return a + b;
    }
    public void LogResult(int result) {
        System.out.println("Result: " + result);
    }
}

public class MathOperations {
    public static void main(String[] args) {
        Operations mathOps = new Operations();

        int result = mathOps.Add(5, 3);

        mathOps.LogResult(result);
    }
}

