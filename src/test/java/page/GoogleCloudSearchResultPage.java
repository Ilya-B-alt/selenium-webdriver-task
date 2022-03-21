package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class GoogleCloudSearchResultPage extends AbstractPage {

    @FindBy (xpath = "//a[@class='gs-title' and contains(@data-ctorig, 'products/calculator')]")
    List<WebElement> searchLink;

    public GoogleCloudSearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage followTheLink () {
        presenceOfAllElementsLocated(By.xpath("//a[@class='gs-title' and contains(@data-ctorig, 'products/calculator')]"));
        if (!searchLink.get(0).getText().startsWith("Google")) {
            driver.navigate().refresh();
            new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions
                            .presenceOfAllElementsLocatedBy(By.xpath("//a[@class='gs-title' and contains(@data-ctorig, 'products/calculator')]")));
        }
        searchLink.get(0).click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
