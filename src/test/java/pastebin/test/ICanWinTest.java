package pastebin.test;

import pastebin.page.PasteBinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ICanWinTest {

    protected WebDriver driver;

    protected static final String NEW_PASTE_TEXT = "Hello from WebDriver";
    protected static final String NEW_PASTE_TITLE = "helloweb";
    PasteBinMainPage pasteBinMainPage;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Enter all info for ICanWinTest")
    public void enterAllNeededInfoSimple() {
        pasteBinMainPage = new PasteBinMainPage(driver)
                .openPage()
                .typeInNewPasteText(NEW_PASTE_TEXT)
                .openExpirationDropdown()
                .selectExpiration10M()
                .typeInNewPasteTitle(NEW_PASTE_TITLE)
                .submitNewPaste();
    }

    @AfterTest(alwaysRun = true)
    public void browserExit() {
        driver.quit();
        driver = null;
    }
}