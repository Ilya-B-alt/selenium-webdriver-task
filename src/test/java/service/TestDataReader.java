package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import static java.io.File.separator;

public class TestDataReader {
//    private static PropertyResourceBundle resourceBundle = (PropertyResourceBundle) PropertyResourceBundle.getBundle(System.getProperty("environment"));
//
//    public static String getTestData(String key) {
//        return resourceBundle.getString(key);
//    }

    private static Properties properties = new Properties();

    public static String loadProperty(String key) {

        try (FileInputStream file = new FileInputStream("src" + separator + "test" + separator
                + "resources" + separator + "dev.properties")) {
            properties.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}

