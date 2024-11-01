package Modules.module9.practice8;

public interface IReport {
    String generate();
}

class SalesReport implements IReport {
    @Override
    public String generate() {
        return "Sales Report: Total sales data...";
    }
}

class UserReport implements IReport {
    @Override
    public String generate() {
        return "User Report: Total users data...";
    }
}

// abstract decorator
abstract class ReportDecorator implements IReport {
    protected IReport report;

    public ReportDecorator(IReport report) {
        this.report = report;
    }

    @Override
    public String generate() {
        return report.generate();
    }
}


// decorators
class DateFilterDecorator extends ReportDecorator {
    private String startDate;
    private String endDate;

    public DateFilterDecorator(IReport report, String startDate, String endDate) {
        super(report);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String generate() {
        return super.generate() + " (Filtered by date from " + startDate + " to " + endDate + ")";
    }
}

class SortingDecorator extends ReportDecorator {
    private String sortBy;

    public SortingDecorator(IReport report, String sortBy) {
        super(report);
        this.sortBy = sortBy;
    }

    @Override
    public String generate() {
        return super.generate() + " (Sorted by " + sortBy + ")";
    }
}

class CsvExportDecorator extends ReportDecorator {
    public CsvExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        return super.generate() + " (Exported to CSV)";
    }
}

class PdfExportDecorator extends ReportDecorator {
    public PdfExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        return super.generate() + " (Exported to PDF)";
    }
}

class ReportSystem {
    public static void main(String[] args) {
        IReport report = new SalesReport();

        // add filter by date and sort
        report = new DateFilterDecorator(report, "2023-01-01", "2023-12-31");
        report = new SortingDecorator(report, "Total Sales");

        // export
        report = new CsvExportDecorator(report);

        System.out.println(report.generate());
    }
}
