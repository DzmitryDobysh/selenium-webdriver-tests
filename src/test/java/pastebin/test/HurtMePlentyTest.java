package pastebin.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import pastebin.page.GoogleCloudMainPage;
import pastebin.page.GoogleCloudPricingCalculatorPage;
import pastebin.spec.BaseSpec;

public class HurtMePlentyTest extends BaseSpec {
    GoogleCloudMainPage cloudMainPage;
    String SEARCH_TERM_MAIN_PAGE = "Google Cloud Platform Pricing Calculator";
    String MANUALLY_CALCULATED_VALUE = "Total Estimated Cost: USD 1,081.20 per 1 month";
    GoogleCloudPricingCalculatorPage cloudCalculatorPage;

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
}