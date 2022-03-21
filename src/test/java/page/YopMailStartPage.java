package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class YopMailStartPage extends AbstractPage {

    @FindBy (xpath = "//div[@class='txtlien']")
    List<WebElement> generateNewEmailButton;

    public YopMailStartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public YopMailGeneratedAddressPage generateAddress () {
        presenceOfAllElementsLocated(By.xpath("//div[@class='txtlien']"));
        generateNewEmailButton.get(0).click();
        return new YopMailGeneratedAddressPage(driver);
    }
}

