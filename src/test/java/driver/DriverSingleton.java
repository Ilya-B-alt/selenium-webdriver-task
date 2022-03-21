package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.io.File.separator;

public class DriverSingleton {

    private static final String RESOURCES_PATH = "src" + separator + "test" + separator + "resources";
    private static WebDriver driver;

    private DriverSingleton() {}

    public static WebDriver getDriver () {
        if (null==driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
        }
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver () {
        driver.quit();
        driver = null;
    }
}
