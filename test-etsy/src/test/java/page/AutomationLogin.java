package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutomationLogin extends BaseTest {
    public AutomationLogin(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@class=\"wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register\"]")
    WebElement registerButton;


    public void clickRegisterButton(){
        wdwait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }


}
