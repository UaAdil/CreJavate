package Modules.module4.homework3;

interface Printer {
    void print(String content);
}

interface Scanner {
    void scan(String content);
}

interface Fax {
    void fax(String content);
}

class BasicPrinter implements Printer {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }
}

class PrintAndScanPrinter implements Printer, Scanner {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }

    @Override
    public void scan(String content) {
        System.out.println("Scanning: " + content);
    }
}



public class AllInOnePrinter implements Printer, Scanner, Fax {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }

    @Override
    public void scan(String content) {
        System.out.println("Scanning: " + content);
    }

    @Override
    public void fax(String content) {
        System.out.println("Faxing: " + content);
    }
}

