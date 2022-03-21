package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleCloudHomePage extends AbstractPage {

    private final String HOME_URL = "https://cloud.google.com/";

    @FindBy (xpath = "//input[@name='q']")
    WebElement searchBox;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudHomePage openPage () {
        driver.get(HOME_URL);
        presenceOfElementLocated(By.xpath("//input[@name='q']"));
        return this;
    }

    public GoogleCloudSearchResultPage writeQueryToSearchBox () {
        elementToBeClickable(searchBox);
        searchBox.click();
        searchBox.sendKeys("Google Cloud Platform Pricing Calculator");
        searchBox.sendKeys(Keys.ENTER);
        return new GoogleCloudSearchResultPage(driver);
    }
}
