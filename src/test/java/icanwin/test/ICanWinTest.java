package icanwin.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ICanWinTest extends EnterAllInfoTest {
    @Test(description = "Check if submitted paste title matches initial paste title")
    public void checkSubmittedPastePageTitle() {
        WebElement titleSubmittedPaste = waitForElement(By.xpath(SUBMITTED_PASTE_TITLE_LOCATOR));
        String actualPageTitle = titleSubmittedPaste.getText();

        Assert.assertEquals(actualPageTitle, NEW_PASTE_TITLE, "Submitted paste title doesn't match initial paste title");
    }


    @Test(description = "Check if submitted paste text matches initial text")
    public void checkSubmittedPasteText() {
        String actualText = pastebinSubmittedPage.getSubmittedPasteText();

        Assert.assertEquals(actualText, NEW_PASTE_TEXT, "Submitted paste text doesn't match initial paste text");
    }
}
