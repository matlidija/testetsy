package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutomationHomeSignIn extends BaseTest {
    public AutomationHomeSignIn(){PageFactory.initElements(driver, this);}

    private static final By profileLink = By.xpath("//div[@data-ge-nav-menu=\"user\"]");
    private static final By signOutBuuton = By.xpath("//a[@href=\"https://www.etsy.com/logout.php?ref=hdr_user_menu-signout\"]");


    @FindBy(xpath = "//div[@data-ge-nav-menu=\"user\"]")
    WebElement clickAccountButton;
    @FindBy(xpath = "//a[@href=\"https://www.etsy.com/logout.php?ref=hdr_user_menu-signout\"]")
    WebElement signOutButton;
    @FindBy(xpath = "//div[@data-appears-component-name=\"Homepage_Vesta_View_WelcomeMessage\"]")
    WebElement welcomeText;
    @FindBy(id = "global-enhancements-search-query")
    WebElement searchField;

    public AutomationHomeSignIn setSearchField (){
        wdwait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.clear();
        searchField.sendKeys("cats");
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean welcomeTextIsDIsplay(){
        wdwait.until(ExpectedConditions.elementToBeClickable(welcomeText));
        return welcomeText.isDisplayed();
    }
    public String welcomeTextIsGet(){
        wdwait.until(ExpectedConditions.elementToBeClickable(welcomeText));
        return welcomeText.getText();
    }

    public AutomationHomeSignIn clickAccountButton(){
        wdwait.until(ExpectedConditions.elementToBeClickable(clickAccountButton));
        clickAccountButton.click();
        return this;
    }

    public void clickSignOutButton(){
        WebElement clickProfile = driver.findElement(profileLink);
        wdwait.until(ExpectedConditions.elementToBeClickable(profileLink));
        WebElement clickSingnOut = driver.findElement(signOutBuuton);
        Actions hoverProfile = new Actions(driver);
        hoverProfile.moveToElement(clickProfile);
        hoverProfile.moveToElement(clickSingnOut);
        hoverProfile.click().build().perform();
    }
}
