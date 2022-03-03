package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutomationRemoveItems extends BaseTest {
    public AutomationRemoveItems(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//div[@class=\"favorite-listing-button-icon-container should-animate \"][1])")
    WebElement removeItemsButton;
    @FindBy(xpath = "//label[@for=\"checkbox_list\"]")
    WebElement removeButtonOk;
    @FindBy(xpath = "//button[contains(text(),\"Done\")]")
    WebElement buttonDone;
    @FindBy(xpath = "(//h3[@class=\"wt-mb-xs-1\"])[2]")
    WebElement notingText;

    public String notingTextIsGet(){
        wdwait.until(ExpectedConditions.elementToBeClickable(notingText));
        return notingText.getText();

    }

    public boolean notingTextIsDisplay(){
        wdwait.until(ExpectedConditions.elementToBeClickable(notingText));
        return notingText.isDisplayed();

    }

    public void clickButtonDone(){
        wdwait.until(ExpectedConditions.elementToBeClickable(buttonDone));
        buttonDone.click();
    }
    public void clickRemoveButtonOk(){
        wdwait.until(ExpectedConditions.elementToBeClickable(removeButtonOk));
        removeButtonOk.click();
    }

    public void clickRemoveItemsButton(){
        wdwait.until(ExpectedConditions.elementToBeClickable(removeItemsButton));
        removeItemsButton.click();
    }
}
