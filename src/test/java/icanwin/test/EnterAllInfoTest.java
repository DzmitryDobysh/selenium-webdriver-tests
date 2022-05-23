package icanwin.test;

import icanwin.page.PastebinSubmittedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import icanwin.page.PasteBinMainPage;

import java.time.Duration;


public abstract class EnterAllInfoTest {

    protected WebDriver driver;

    protected static final String NEW_PASTE_TEXT = "Hello from WebDriver";
    protected static final String NEW_PASTE_TITLE = "helloweb";
    protected static final String SUBMITTED_PASTE_TITLE_LOCATOR = "//div[@class='info-top']/h1";
    PasteBinMainPage pasteBinMainPage;
    PastebinSubmittedPage pastebinSubmittedPage;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pasteBinMainPage = new PasteBinMainPage(driver)
                .openPage()
                .typeInNewPasteText(NEW_PASTE_TEXT)
                .openExpirationDropdown()
                .selectExpiration10M()
                .typeInNewPasteTitle(NEW_PASTE_TITLE)
                .submitNewPaste();
        pastebinSubmittedPage = new PastebinSubmittedPage(driver);
    }

    public WebElement waitForElement(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @AfterTest(alwaysRun = true)
    public void browserExit() {
        driver.quit();
        driver = null;
    }
}
