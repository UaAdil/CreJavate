package Modules.module6.practice5;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.loadConfiguration("loggerConfig.txt");

        Thread thread1 = new Thread(() -> {
            Logger.getInstance().log("This is an INFO message from thread 1", LogLevel.INFO);
        });

        Thread thread2 = new Thread(() -> {
            Logger.getInstance().log("This is a WARNING message from thread 2", LogLevel.WARNING);
        });

        Thread thread3 = new Thread(() -> {
            Logger.getInstance().log("This is an ERROR message from thread 3", LogLevel.ERROR);
        });

        thread1.start();
        thread2.start();
        thread3.start();

        LogReader logReader = new LogReader("app.log");
        System.out.println("\nDisplaying ERROR logs:");
        logReader.displayLogs(LogLevel.ERROR);
    }
}

