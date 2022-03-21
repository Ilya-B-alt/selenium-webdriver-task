package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

public class YopMailGeneratedAddressPage extends AbstractPage {

    @FindBy (xpath = "//div[@id='egen']")
    WebElement generatedEmail;

    @FindBy (xpath = "//button[@onclick='egengo();']")
    WebElement checkEmailButton;

    public YopMailGeneratedAddressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String copyEmailAddress () {
        return generatedEmail.getText();
    }

    public YopMailBoxPage checkMail () {
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        elementToBeClickable(checkEmailButton);
        checkEmailButton.click();
        return new YopMailBoxPage(driver);
    }
}
