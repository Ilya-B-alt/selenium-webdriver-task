package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;

import static java.io.File.*;

@Listeners ({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    private static final String RESOURCES_PATH = "src" + separator + "test" + separator + "resources";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup () {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown () {
        DriverSingleton.closeDriver();
    }

}
