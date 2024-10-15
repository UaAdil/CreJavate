package Modules.module6.practice5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogReader {
    private String logFilePath;

    public LogReader(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public List<String> readLogs(LogLevel filterLevel) {
        List<String> filteredLogs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("[" + filterLevel + "]")) {
                    filteredLogs.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filteredLogs;
    }

    public void displayLogs(LogLevel filterLevel) {
        List<String> logs = readLogs(filterLevel);
        logs.forEach(System.out::println);
    }
}
