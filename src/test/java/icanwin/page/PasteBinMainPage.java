package icanwin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasteBinMainPage extends BasePage {
    private final String BASE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    WebElement textAreaNewPaste;

    @FindBy(id = "select2-postform-expiration-container")
    WebElement expirationDropdown;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    WebElement expiration10M;

    @FindBy(id = "postform-name")
    WebElement inputTitle;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonNewPaste;

    public PasteBinMainPage(WebDriver driver) {
        super(driver);
    }

    public PasteBinMainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public PasteBinMainPage typeInNewPasteText(String newPasteText) {
        waitForWebElementVisible(textAreaNewPaste).sendKeys(newPasteText);
        return this;
    }

    public PasteBinMainPage openExpirationDropdown() {
        expirationDropdown.click();
        return this;
    }

    public PasteBinMainPage selectExpiration10M() {
        expiration10M.click();
        return this;
    }

    public PasteBinMainPage typeInNewPasteTitle(String newPasteTitle) {
        inputTitle.sendKeys(newPasteTitle);
        return this;
    }

    public PasteBinMainPage submitNewPaste() {
        buttonNewPaste.click();
        return this;
    }
}