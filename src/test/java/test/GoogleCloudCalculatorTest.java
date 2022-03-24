package test;

import model.VirtualMachine;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.GoogleCloudHomePage;
import page.GoogleCloudPricingCalculatorPage;
import service.VirtualMachineCreator;

import java.util.Properties;

public class GoogleCloudCalculatorTest extends CommonConditions {


    private String estimatedCostOnGooglePage;
    private String monthlyCostInEmail;
    private VirtualMachine virtualMachine;
    private Properties properties;


    @Test (description = "calculated total monthly cost on google page is equal to cost in email letter")
    public void compareCosts () {

        virtualMachine = VirtualMachineCreator.withCredentialsFromProperty();
        GoogleCloudPricingCalculatorPage calculatorPage = new GoogleCloudHomePage(driver)
                .openPage()
                .writeQueryToSearchBox()
                .followTheLink()
                .writeNumberOfInstances(virtualMachine.getNumberOfInstances())
                .chooseMachineClass(virtualMachine.getMachineClass())
                .chooseMachineType(virtualMachine.getMachineType())
                .chooseRegion(virtualMachine.getRegion())
                .chooseUsageTime(virtualMachine.getCommittedUsageTime())
                .addToEstimate();
        estimatedCostOnGooglePage = calculatorPage.getTotalEstimatedMonthlyCost();
        String generatedEmailAddress = calculatorPage
                .openYopMailPage()
                .generateAddress()
                .copyEmailAddress();
        monthlyCostInEmail = calculatorPage.sendEmail(generatedEmailAddress)
                .checkMail()
                .getEstimatedMonthlyCost();
        Assert.assertEquals(estimatedCostOnGooglePage, monthlyCostInEmail,
                 "Estimated cost on google page doesn't match cost on mail page");
     }
}
