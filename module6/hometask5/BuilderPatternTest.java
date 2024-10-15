package Modules.module6.hometask5;

public class BuilderPatternTest {
    public static void main(String[] args) {
        IReportBuilder textBuilder = new TextReportBuilder();
        ReportDirector director = new ReportDirector(textBuilder);
        director.constructReport("Monthly Report", "This is the content of the report.", "End of Report.");
        Report textReport = director.getReport();
        System.out.println("Text Report:");
        System.out.println(textReport);

        // Создание HTML-отчета
        IReportBuilder htmlBuilder = new HtmlReportBuilder();
        director = new ReportDirector(htmlBuilder);
        director.constructReport("HTML Report", "This is the <b>HTML</b> content.", "End of HTML Report.");
        Report htmlReport = director.getReport();
        System.out.println("\nHTML Report:");
        System.out.println(htmlReport);
    }
}
