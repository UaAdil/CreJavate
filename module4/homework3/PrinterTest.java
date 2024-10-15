package Modules.module4.homework3;

public class PrinterTest {
    public static void main(String[] args) {
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print("Basic document");

        Printer allInOnePrinter = new AllInOnePrinter();
        allInOnePrinter.print("All-in-One document");

        Scanner scanPrinter = new PrintAndScanPrinter();
        scanPrinter.scan("Scan document");
    }
}

