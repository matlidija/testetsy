package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AutomationRegister extends BaseTest {
    public AutomationRegister(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "email")
    WebElement customerNewEmailField;
    @FindBy(id = "join_neu_first_name_field")
    WebElement customerFirstnameField;
    @FindBy(id = "join_neu_password_field")
    WebElement customerPasswordField;
    @FindBy(xpath = "//button[@class=\"wt-btn wt-btn--primary wt-width-full\"]")
    WebElement registerAccButton;
    @FindBy(xpath = "//button[@class=\"wt-btn wt-btn--primary wt-width-full\"]")
    WebElement loginButton;

    public AutomationRegister clickLoginButton (){
        wdwait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return this;
    }


    public void clickRegisterAccButton(){
        wdwait.until(ExpectedConditions.elementToBeClickable(registerAccButton));
        registerAccButton.click();
    }
    public AutomationRegister customerNewEmailField(String other){
        wdwait.until(ExpectedConditions.elementToBeClickable(customerNewEmailField));
        customerNewEmailField.clear();
        customerNewEmailField.sendKeys(other);
        return this;
    }
    public AutomationRegister customerFirstnameField(String other){
        wdwait.until(ExpectedConditions.elementToBeClickable(customerFirstnameField));
        customerFirstnameField.clear();
        customerFirstnameField.sendKeys(other);
        return this;
    }
    public AutomationRegister customerPasswordField(String other){
        wdwait.until(ExpectedConditions.elementToBeClickable(customerPasswordField));
        customerPasswordField.clear();
        customerPasswordField.sendKeys(other);
        return this;
    }
}
