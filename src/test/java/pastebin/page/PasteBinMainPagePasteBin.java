package pastebin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spec.BaseSpec;

public class PasteBinMainPagePasteBin extends BaseSpec {
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

    @FindBy(id = "select2-postform-format-container")
    WebElement syntaxDropdown;
    @FindBy(xpath = "//li[text()='Bash']")
    WebElement syntaxBash;

    public PasteBinMainPagePasteBin(WebDriver driver) {
        super(driver);
    }

    public PasteBinMainPagePasteBin openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public PasteBinMainPagePasteBin typeInNewPasteText(String newPasteText) {
        waitForWebElementVisible(textAreaNewPaste).sendKeys(newPasteText);
        return this;
    }

    public PasteBinMainPagePasteBin openExpirationDropdown() {
        expirationDropdown.click();
        return this;
    }

    public PasteBinMainPagePasteBin selectExpiration10M() {
        expiration10M.click();
        return this;
    }

    public PasteBinMainPagePasteBin typeInNewPasteTitle(String newPasteTitle) {
        inputTitle.sendKeys(newPasteTitle);
        return this;
    }

    public PasteBinMainPagePasteBin submitNewPaste() {
        buttonNewPaste.click();
        return this;
    }

    public PasteBinMainPagePasteBin openSyntaxDropdown() {
        syntaxDropdown.click();
        return this;
    }

    public PasteBinMainPagePasteBin selectSyntaxBash() {
        syntaxBash.click();
        return this;
    }
}