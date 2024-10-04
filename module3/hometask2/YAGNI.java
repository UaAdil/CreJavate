package Modules.module3.hometask2;

class User {
    private String name;
    private String email;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

class UserRepository {
    public void saveToDatabase(User user) {
        // Logics
    }
}

class EmailService {
    public void sendEmail(User user) {
        // Logics
    }
}

class AddressLabelPrinter {
    public void printAddressLabel(User user) {
        // Logics
    }
}

class FileReader {
    public String readFile(String filePath) {
        return "file content";
    }
}

class ReportGenerator {
    public void generateReport(String type) {
        if ("PDF".equalsIgnoreCase(type)) {
        } else if ("Excel".equalsIgnoreCase(type)) {
        } else if ("HTML".equalsIgnoreCase(type)) {
        } else {
            throw new IllegalArgumentException("Unknown report type: " + type);
        }
    }
}

public class YAGNI {
    public static void main(String[] args) {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setAddress("123 Main St");

        UserRepository repository = new UserRepository();
        repository.saveToDatabase(user);

        EmailService emailService = new EmailService();
        emailService.sendEmail(user);

        AddressLabelPrinter printer = new AddressLabelPrinter();
        printer.printAddressLabel(user);

        FileReader reader = new FileReader();
        String content = reader.readFile("path/to/file.txt");
        System.out.println(content);

        ReportGenerator generator = new ReportGenerator();
        generator.generateReport("PDF");
    }
}
