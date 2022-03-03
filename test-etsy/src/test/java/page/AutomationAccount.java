package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutomationAccount extends BaseTest {
    public AutomationAccount(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "account")
    WebElement accountButton;

    public boolean accountButtonIsDisplay(){
        wdwait.until(ExpectedConditions.elementToBeClickable(accountButton));
        return accountButton.isDisplayed();
    }

    public String accountButtonIsGetText(){
        wdwait.until(ExpectedConditions.elementToBeClickable(accountButton));
        return accountButton.getText();
    }
}
