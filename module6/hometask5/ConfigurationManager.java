package Modules.module6.hometask5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private static final Object lock = new Object();
    private Map<String, String> settings;

    private ConfigurationManager() {
        settings = new HashMap<>();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (lock) { // Блокировка для обеспечения потокобезопасности
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public void loadSettingsFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    settings.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
    }

    public void saveSettingsToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : settings.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        }
    }

    public String getSetting(String key) {
        return settings.get(key);
    }

    public void setSetting(String key, String value) {
        settings.put(key, value);
    }

    public void showSettings() {
        System.out.println("Current Settings:");
        for (Map.Entry<String, String> entry : settings.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
