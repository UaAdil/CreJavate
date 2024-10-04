package Modules.module3.hometask2;
class Logger {
    public void log(String level, String message) {
        System.out.println(level.toUpperCase() + ": " + message);
    }
}

// class for saving general configurations
class Configuration {
    private static final String connectionString = "Server=myServer;Database=myDb;User Id=myUser;Password=myPass;";

    public static String getConnectionString() {
        return connectionString;
    }
}

// service for work with database
class DatabaseService {
    public void connect() {
        String connectionString = Configuration.getConnectionString();
        System.out.println("Connecting to database with connection string: " + connectionString);
    }
}

// Service for logging
class LoggingService {
    public void log(String message) {
        String connectionString = Configuration.getConnectionString();
        System.out.println("Logging message to database with connection string: " + connectionString);
    }
}

// testing
public class DRY {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.log("error", "This is an error message.");
        logger.log("warning", "This is a warning message.");
        logger.log("info", "This is an info message.");

        DatabaseService dbService = new DatabaseService();
        dbService.connect();

        LoggingService loggingService = new LoggingService();
        loggingService.log("This is a log message.");
    }
}
