package pastebin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pastebin.page.GoogleCloudMainPage;
import pastebin.page.GoogleCloudPricingCalculatorPage;

public class HurtMePlentyTest {
    protected WebDriver driver;
    GoogleCloudMainPage cloudMainPage;
    String SEARCH_TERM_MAIN_PAGE = "Google Cloud Platform Pricing Calculator";
    String MANUALLY_CALCULATED_VALUE = "Total Estimated Cost: USD 1,081.20 per 1 month";
    GoogleCloudPricingCalculatorPage cloudCalculatorPage;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Fill in estimation form and compare Total Cost between autotest and manual")
    public void fillInEstimationForm() {
        cloudMainPage = new GoogleCloudMainPage(driver)
                .openPage()
                .searchTerm(SEARCH_TERM_MAIN_PAGE)
                .clickCalculatorPage();
        cloudCalculatorPage = new GoogleCloudPricingCalculatorPage(driver)
                .switchToCalculatorIFrame()
                .fillInEstimationForm()
                .clickAddToEstimateButton();
        String costOnCalcPage = cloudCalculatorPage.getTotalCost();

        Assert.assertEquals(costOnCalcPage, MANUALLY_CALCULATED_VALUE, "Total Cost from autotest doesn't match the one from the manual on Calculator page");
    }

    @AfterTest(alwaysRun = true)
    public void browserExit() {
        driver.quit();
        driver = null;
    }
}