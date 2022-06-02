package googlepricecalc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spec.BaseSpec;

public class GoogleCloudPricingCalculatorPage extends BaseSpec {
    @FindBy(xpath = "//iframe[contains(@src, '/products/calculator')]")
    WebElement frameMain;

    @FindBy(xpath = "//md-tab-item[@aria-controls='tab-content-1']")
    WebElement buttonComputeEngine;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement inputNumberOfInstances;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.label']")
    WebElement inputPurpose;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    WebElement dropdownSoftware;
    @FindBy(xpath = "//md-option[@value='free']")
    WebElement itemSoftware;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    WebElement dropdownClass;
    @FindBy(xpath = "//md-select-menu[@style]/descendant::md-option[@value='regular']")
    WebElement itemClass;

    @FindBy(xpath = "//md-select[@name='series']")
    WebElement dropdownSeries;
    @FindBy(xpath = "//md-option[@value='n1']")
    WebElement itemSeries;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    WebElement dropdownMachineType;
    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    WebElement itemMachineType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs' and @ng-model='listingCtrl.computeServer.addGPUs']")
    WebElement checkboxAddGPUs;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    WebElement dropboxNumberOfGPUs;
    @FindBy(xpath = "//md-option[@value='1' and contains(@ng-repeat, 'gpuType')]")
    WebElement itemNumberOfGPUs;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    WebElement dropboxGPUType;
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    WebElement itemGPUType;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    WebElement dropdownSSD;
    @FindBy(xpath = "//md-option[@value='2' and contains(@ng-repeat, 'item in listingCtrl.dynamicSsd.computeServer')]")
    WebElement itemSSD;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location'][@ng-model='listingCtrl.computeServer.location']")
    WebElement dropdownLocation;
    @FindBy(xpath = "//md-select-menu[@class='md-overflow']/descendant::md-option[@value='europe-west3' and contains(@ng-repeat, 'item in listingCtrl.fullRegionList')]")
    WebElement itemLocation;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    WebElement dropdownUsage;
    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']/descendant::md-option[@ng-value='1'][@value='1']")
    WebElement itemUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate' and contains(@ng-click, 'addComputeServer')]")
    WebElement buttonAddToEstimate;

    @FindBy(xpath = "//h2/b[@class='ng-binding']")
    WebElement textTotalCost;

    @FindBy(xpath = "//button[@title='Email Estimate']")
    WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    WebElement inputEmail;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement buttonSendEmail;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {

        super(driver);
    }

    public GoogleCloudPricingCalculatorPage switchToCalculatorIFrame() {
        driver.switchTo().frame(frameMain);
        driver.switchTo().frame("myFrame");
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillInEstimationForm() {
        String instances = "4";

        waitForWebElementVisible(buttonComputeEngine).click();
        inputNumberOfInstances.sendKeys(instances);
        inputPurpose.clear();
        dropdownSoftware.click();
        waitForWebElementVisible(itemSoftware).click();
        dropdownClass.click();
        waitForWebElementVisible(itemClass).click();
        dropdownSeries.click();
        waitForWebElementVisible(itemSeries).click();
        dropdownMachineType.click();
        waitForWebElementVisible(itemMachineType).click();
        checkboxAddGPUs.click();
        dropboxGPUType.click();
        waitForWebElementVisible(itemGPUType).click();
        waitForWebElementVisible(dropboxNumberOfGPUs).click();
        waitForWebElementVisible(itemNumberOfGPUs).click();
        dropdownSSD.click();
        waitForWebElementVisible(itemSSD).click();
        dropdownLocation.click();
        waitForWebElementVisible(itemLocation).click();
        dropdownUsage.click();
        waitForWebElementVisible(itemUsage).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickAddToEstimateButton() {
        buttonAddToEstimate.click();
        return this;
    }

    public String getTotalCost() {
        return waitForWebElementVisible(textTotalCost).getText();
    }

    public GoogleCloudPricingCalculatorPage clickEmailEstimateButton() {
        buttonEmailEstimate.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterTempEMail(String tempEmail) {
        waitForWebElementVisible(inputEmail).sendKeys(tempEmail);
        return this;
    }

    public void sendEmail() {
        buttonSendEmail.click();
    }
}