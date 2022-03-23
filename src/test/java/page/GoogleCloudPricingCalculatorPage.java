package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private String variableForCheck;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement numberOfInstancesContainer;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    WebElement vmClassContainer;

    private static final String machineClassPattern = "//md-option[@role='option' and contains(@id, '%s') and @class='md-ink-ripple']";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    WebElement machineTypeContainer;

    private static final String machineTypePattern = "//md-option[@role='option' and contains(text(), '%s')]";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    WebElement regionContainer;

    private static final String regionPattern = "//md-option[@role='option' and contains(@id, '%s')]";

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    WebElement committedUsageContainer;

    private static final String committedUsageChoicePattern = "//md-option[@role='option' and contains(@id, '%s')]";

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    List<WebElement> addToEstimateButton;

    @FindBy(xpath = "//md-list-item[@role='listitem']/div[@class='ng-binding']")
    WebElement priceOnGooglePage;

    @FindBy(xpath = "//button[@ng-click='cloudCartCtrl.showEmailForm();']")
    WebElement emailEstimate;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement sendEmailButton;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage writeNumberOfInstances(String numberOfKeys) {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        visibilityOfElement(numberOfInstancesContainer);
        numberOfInstancesContainer.click();
        numberOfInstancesContainer.sendKeys(numberOfKeys);
        logger.info("wrote number of instances");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseMachineClass(String machineClass) {
        elementToBeClickable(vmClassContainer);
        vmClassContainer.click();
        WebElement vmClassChoice = driver.findElement(By.xpath(buildLocatorForMachineClassChoice(machineClass)));
        elementToBeClickable(vmClassChoice);
        vmClassChoice.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseMachineType(String machineType) {
        elementToBeClickable(machineTypeContainer);
        machineTypeContainer.click();
        WebElement machineTypeChoice = driver.findElement(By.xpath(buildLocatorForMachineTypeChoice(machineType)));
        elementToBeClickable(machineTypeChoice);
        machineTypeChoice.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseRegion(String region) {
        elementToBeClickable(regionContainer);
        regionContainer.click();
        WebElement regionChoice = driver.findElement(By.xpath(buildLocatorForRegionChoice(region)));
        elementToBeClickable(regionChoice);
        regionChoice.click();
        logger.info("chose region");
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseUsageTime(String committedUsageTime) {
        elementToBeClickable(committedUsageContainer);
        committedUsageContainer.click();
        WebElement usageTime = driver.findElement(By.xpath(buildLocatorForUsageTimeChoice(committedUsageTime)));
        elementToBeClickable(usageTime);
        usageTime.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage addToEstimate() {
        addToEstimateButton.get(0).click();
        return this;
    }

    public YopMailStartPage openYopMailPage() {
        driver.switchTo().defaultContent();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://yopmail.com/ ");
        return new YopMailStartPage(driver);
    }

    public YopMailGeneratedAddressPage sendEmail(String email) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        emailEstimate.click();
        visibilityOfElement(emailInput);
        emailInput.sendKeys(email);
        elementToBeClickable(sendEmailButton);
        sendEmailButton.click();
        return new YopMailGeneratedAddressPage(driver);
    }

    public String getTotalEstimatedMonthlyCost() {
        return priceOnGooglePage.getText();
    }

    private String buildLocatorForRegionChoice(String contains) {
        return String.format(regionPattern, contains);
    }

    private String buildLocatorForUsageTimeChoice(String contains) {
        return String.format(committedUsageChoicePattern, contains);
    }

    private String buildLocatorForMachineTypeChoice(String contains) {
        return String.format(machineTypePattern, contains);
    }

    private String buildLocatorForMachineClassChoice(String contains) {
        return String.format(machineClassPattern, contains);
    }
}
