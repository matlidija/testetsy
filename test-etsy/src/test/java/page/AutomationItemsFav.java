package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutomationItemsFav extends BaseTest {
    public AutomationItemsFav(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[@class=\"currency-value\"]")
    WebElement itemsColection;

    public String itemsColectionIsGetText(){
        wdwait.until(ExpectedConditions.elementToBeClickable(itemsColection));
        return itemsColection.getText();
    }

    public boolean itemsColectionIsDisplay(){
        wdwait.until(ExpectedConditions.elementToBeClickable(itemsColection));
        return itemsColection.isDisplayed();
    }
}
