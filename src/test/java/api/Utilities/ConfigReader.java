package api.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    // Static block to load properties when the class is loaded
    static {
        try {
            // Use relative path for the properties file located in src/test/resources
            String path = System.getProperty("user.dir") + "/src/test/resources/Routes.properties"; 
            FileInputStream file = new FileInputStream(path); 
            properties = new Properties();
            properties.load(file);  // Load the properties
            file.close();  // Always close the file input stream
        } catch (IOException e) {
            System.out.println("Exception while loading properties file: " + e.getMessage());
            e.printStackTrace();  // Log the full stack trace for better debugging
        }
    }

    // Method to get property value
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
