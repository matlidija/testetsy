package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutomationHome extends BaseTest {
    public AutomationHome(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@class=\"wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin\"]")
    WebElement signInButton;
    @FindBy(xpath = "//div[@class=\"wt-menu wt-tooltip ge-menu ge-menu--body-below-trigger ge-menu--you-menu wt-tooltip--disabled-touch wt-menu--bottom wt-menu--right\"]")
    WebElement clickAccountButton;


    public void clickSignButton() {
        wdwait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();

    }

}
