package Modules.module6.hometask5;

import java.io.IOException;

public class SingletonTest {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        System.out.println("Are config1 and config2 the same instance? " + (config1 == config2));

        config1.setSetting("AppName", "My Application");
        config1.setSetting("Version", "1.0.0");

        config1.showSettings();

        try {
            config1.loadSettingsFromFile("config.txt");
            config1.showSettings();
        } catch (IOException e) {
            System.out.println("Error loading settings: " + e.getMessage());
        }

        try {
            config2.saveSettingsToFile("saved_config.txt");
        } catch (IOException e) {
            System.out.println("Error saving settings: " + e.getMessage());
        }

        config2.showSettings();
    }
}
