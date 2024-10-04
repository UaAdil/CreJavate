package Modules.module5.practice4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select document type (report, resume, letter, invoice): ");
        String documentType = scanner.nextLine().toLowerCase();

        DocumentCreator documentCreator = null;

        switch (documentType) {
            case "report":
                documentCreator = new ReportCreator();
                break;
            case "resume":
                documentCreator = new ResumeCreator();
                break;
            case "letter":
                documentCreator = new LetterCreator();
                break;
            case "invoice":
                documentCreator = new InvoiceCreator();
                break;
            default:
                System.out.println("Invalid document type.");
                return;
        }

        Document document = documentCreator.CreateDocument();
        document.Open();
    }
}
