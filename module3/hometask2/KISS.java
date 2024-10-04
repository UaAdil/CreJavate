package Modules.module3.hometask2;

class NumberProcessor {
    public void processNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }

        for (int number : numbers) {
            if (number > 0) {
                System.out.println(number);
            }
        }
    }
}

class PositiveNumberPrinter {
    public void printPositiveNumbers(int[] numbers) {
        for (int number : numbers) {
            if (number > 0) {
                System.out.println(number);
            }
        }
    }
}

class MathOperations {
    public int divide(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
}

public class KISS {
    public static void main(String[] args) {
        NumberProcessor processor = new NumberProcessor();
        int[] numbers = {1, -2, 3, 0, 5};
        processor.processNumbers(numbers);

        PositiveNumberPrinter printer = new PositiveNumberPrinter();
        printer.printPositiveNumbers(numbers);

        MathOperations mathOps = new MathOperations();
        System.out.println(mathOps.divide(10, 2));
        System.out.println(mathOps.divide(10, 0));
    }
}

