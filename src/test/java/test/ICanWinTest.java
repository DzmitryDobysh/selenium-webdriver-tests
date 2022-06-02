package test;

import pastebin.page.PasteBinMainPagePasteBin;
import org.testng.annotations.Test;
import spec.TestSpec;

public class ICanWinTest extends TestSpec {

    protected static final String NEW_PASTE_TEXT = "Hello from WebDriver";
    protected static final String NEW_PASTE_TITLE = "helloweb";
    PasteBinMainPagePasteBin pasteBinMainPage;

    @Test(description = "Enter all info for ICanWinTest")
    public void enterAllNeededInfoSimple() {
        pasteBinMainPage = new PasteBinMainPagePasteBin(driver)
                .openPage()
                .typeInNewPasteText(NEW_PASTE_TEXT)
                .openExpirationDropdown()
                .selectExpiration10M()
                .typeInNewPasteTitle(NEW_PASTE_TITLE)
                .submitNewPaste();
    }
}