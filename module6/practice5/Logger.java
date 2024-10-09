package Modules.module6.practice5;

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
    private LogLevel currentLogLevel;
    private String logFilePath;

    private Logger(LogLevel level, String logFilePath) {
        this.currentLogLevel = level;
        this.logFilePath = logFilePath;
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Logger(LogLevel.INFO, "app.log"); // Настройки по умолчанию
                }
            }
        }
        return instance;
    }

    public void log(String message, LogLevel level) {
        if (level.ordinal() >= currentLogLevel.ordinal()) {
            String formattedMessage = formatMessage(message, level);
            writeToFile(formattedMessage);
        }
    }

    private String formatMessage(String message, LogLevel level) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());
        return timestamp + " [" + level + "]: " + message;
    }

    private void writeToFile(String message) {
        synchronized (lock) {
            try (FileWriter fw = new FileWriter(logFilePath, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLogLevel(LogLevel level) {
        this.currentLogLevel = level;
    }

    public void loadConfiguration(String configFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(configFilePath))) {
            String logLevel = br.readLine();
            String filePath = br.readLine();
            this.currentLogLevel = LogLevel.valueOf(logLevel.toUpperCase());
            this.logFilePath = filePath;
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

