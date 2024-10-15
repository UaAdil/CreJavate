package Modules.module6.lab5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

enum LogLevel {
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private static Logger instance;
    private static Object lock = new Object();
    private LogLevel logLevel = LogLevel.INFO;
    private String logFilePath = "log.txt";     // path to log.txt
    private PrintWriter writer;

    private Logger() {
        try {
            writer = new PrintWriter(new FileWriter(logFilePath, true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }

    public void setLogFilePath(String path) {
        this.logFilePath = path;
        try {
            if (writer != null) {
                writer.close();
            }
            writer = new PrintWriter(new FileWriter(logFilePath, true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message, LogLevel level) {
        if (level.ordinal() >= logLevel.ordinal()) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String logMessage = String.format("[%s] [%s] %s", timestamp, level, message);
            synchronized (lock) {
                writer.println(logMessage);
            }
        }
    }

    public void readLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
