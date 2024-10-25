package Modules.module8.practice7;

// Паттерн "Шаблонный метод"
abstract class ReportGenerator {
    public final void generateReport() {
        fetchData();
        formatData();
        if (customerWantsSave()) { saveReport(); }
        sendReport();
    }

    protected abstract void fetchData();
    protected abstract void formatData();
    protected void saveReport() {
        System.out.println("Report saved.");
    }

    protected void sendReport() {
        System.out.println("Report sent via email.");
    }

    protected boolean customerWantsSave() { return true; }
}

class PdfReport extends ReportGenerator {
    protected void fetchData() { System.out.println("Fetching data for PDF report."); }
    protected void formatData() { System.out.println("Formatting data for PDF report."); }
}

class ExcelReport extends ReportGenerator {
    protected void fetchData() { System.out.println("Fetching data for Excel report."); }
    protected void formatData() { System.out.println("Formatting data for Excel report."); }
}

class HtmlReport extends ReportGenerator {
    protected void fetchData() { System.out.println("Fetching data for HTML report."); }
    protected void formatData() { System.out.println("Formatting data for HTML report."); }
    protected boolean customerWantsSave() { return false; }
}

public class ReportTest {
    public static void main(String[] args) {
        ReportGenerator pdfReport = new PdfReport();
        pdfReport.generateReport();

        ReportGenerator excelReport = new ExcelReport();
        excelReport.generateReport();

        ReportGenerator htmlReport = new HtmlReport();
        htmlReport.generateReport();
    }
}
