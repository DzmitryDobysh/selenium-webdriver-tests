package icanwin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinSubmittedPage extends BasePage {

    @FindBy(xpath = "//textarea")
    WebElement textSubmittedPaste;

    public PastebinSubmittedPage(WebDriver driver) {
        super(driver);
    }

    public String getSubmittedPasteText() {
        return textSubmittedPaste.getText();
    }
}