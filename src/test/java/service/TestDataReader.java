package service;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class TestDataReader {
    private static PropertyResourceBundle resourceBundle = (PropertyResourceBundle) PropertyResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData (String key) {
        return resourceBundle.getString(key);
    }
}
