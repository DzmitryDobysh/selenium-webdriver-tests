package pastebin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spec.BaseSpec;

public class PastebinSubmittedPastePagePasteBin extends BaseSpec {
    @FindBy(xpath = "//div[@class='left']/a[text()='Bash']")
    WebElement syntaxSubmittedPaste;

    @FindBy(xpath = "//textarea")
    WebElement textSubmittedPaste;

    public PastebinSubmittedPastePagePasteBin(WebDriver driver) {
        super(driver);
    }

    public String getSyntaxSubmittedPaste() {
        return syntaxSubmittedPaste.getText();
    }

    public String getSubmittedPasteText() {
        return textSubmittedPaste.getText();
    }
}