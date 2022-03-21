package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class YopMailBoxPage extends AbstractPage {

    @FindBy (xpath = "//button[@id='refresh']")
    WebElement refreshButton;

    @FindBy (xpath = "//td/h3")
    List<WebElement> estimatedMonthlyCost; //2

    public YopMailBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getEstimatedMonthlyCost () {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        refreshButton.click();
        driver.switchTo().frame("ifmail");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(estimatedMonthlyCost));
        return estimatedMonthlyCost.get(1).getText();
    }
}
