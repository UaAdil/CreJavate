package Modules.module6.hometask5;

public interface IReportBuilder {
    void setHeader(String header);
    void setContent(String content);
    void setFooter(String footer);
    Report getReport();
}

class Report {
    private String header;
    private String content;
    private String footer;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "Header: " + header + "\nContent: " + content + "\nFooter: " + footer;
    }
}

class TextReportBuilder implements IReportBuilder {
    private Report report;

    public TextReportBuilder() {
        this.report = new Report();
    }

    @Override
    public void setHeader(String header) {
        report.setHeader("TEXT HEADER: " + header);
    }

    @Override
    public void setContent(String content) {
        report.setContent(content);
    }

    @Override
    public void setFooter(String footer) {
        report.setFooter("TEXT FOOTER: " + footer);
    }

    @Override
    public Report getReport() {
        return this.report;
    }
}

class HtmlReportBuilder implements IReportBuilder {
    private Report report;

    public HtmlReportBuilder() {
        this.report = new Report();
    }

    @Override
    public void setHeader(String header) {
        report.setHeader("<h1>" + header + "</h1>");
    }

    @Override
    public void setContent(String content) {
        report.setContent("<p>" + content + "</p>");
    }

    @Override
    public void setFooter(String footer) {
        report.setFooter("<footer>" + footer + "</footer>");
    }

    @Override
    public Report getReport() {
        return this.report;
    }
}

class ReportDirector {
    private IReportBuilder builder;

    public ReportDirector(IReportBuilder builder) {
        this.builder = builder;
    }

    public void constructReport(String header, String content, String footer) {
        builder.setHeader(header);
        builder.setContent(content);
        builder.setFooter(footer);
    }

    public Report getReport() {
        return builder.getReport();
    }
}

class XmlReportBuilder implements IReportBuilder {
    private Report report;

    public XmlReportBuilder() {
        this.report = new Report();
    }

    @Override
    public void setHeader(String header) {
        report.setHeader("<header>" + header + "</header>");
    }

    @Override
    public void setContent(String content) {
        report.setContent("<content>" + content + "</content>");
    }

    @Override
    public void setFooter(String footer) {
        report.setFooter("<footer>" + footer + "</footer>");
    }

    @Override
    public Report getReport() {
        return this.report;
    }
}
