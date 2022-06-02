package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pastebin.page.PasteBinMainPagePasteBin;
import pastebin.page.PastebinSubmittedPastePagePasteBin;
import spec.TestSpec;

import java.time.Duration;


public class BringItOnTest extends TestSpec {
    protected static final String NEW_PASTE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    protected static final String NEW_PASTE_TITLE = "how to gain dominance among developers";
    protected static final String SUBMITTED_PASTE_TITLE_LOCATOR = "//div[@class='info-top']/h1";
    protected static final String EXPECTED_PASTE_SYNTAX = "Bash";
    PasteBinMainPagePasteBin pasteBinMainPage;
    PastebinSubmittedPastePagePasteBin pastebinSubmittedPastePage;

    @Test(description = "Enter all info for BringItOnTest", groups = "main")
    public void enterAllNeededInfoExtended() {
        pasteBinMainPage = new PasteBinMainPagePasteBin(driver)
                .openPage()
                .typeInNewPasteText(NEW_PASTE_TEXT)
                .openSyntaxDropdown()
                .selectSyntaxBash()
                .openExpirationDropdown()
                .selectExpiration10M()
                .typeInNewPasteTitle(NEW_PASTE_TITLE)
                .submitNewPaste();
        pastebinSubmittedPastePage = new PastebinSubmittedPastePagePasteBin(driver);
    }

    @Test(description = "Check if submitted paste title matches initial paste title", dependsOnGroups = "main")
    public void checkSubmittedPastePageTitle() {
        WebElement titleSubmittedPaste = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUBMITTED_PASTE_TITLE_LOCATOR)));
        String actualPageTitle = titleSubmittedPaste.getText();

        Assert.assertEquals(actualPageTitle, NEW_PASTE_TITLE, "Submitted paste title doesn't match initial paste title");
    }

    @Test(description = "Check if syntax highlighting is Bash", dependsOnGroups = "main")
    public void checkSubmittedPasteSyntaxHighlighting() {
        String actualSyntax = pastebinSubmittedPastePage.getSyntaxSubmittedPaste();

        Assert.assertEquals(actualSyntax, EXPECTED_PASTE_SYNTAX, "Submitted paste syntax highlighting is not Bash");
    }

    @Test(description = "Check if submitted paste text matches initial text", dependsOnGroups = "main")
    public void checkSubmittedPasteText() {
        String actualText = pastebinSubmittedPastePage.getSubmittedPasteText();

        Assert.assertEquals(actualText, NEW_PASTE_TEXT, "Submitted paste text doesn't match initial paste text");
    }
}