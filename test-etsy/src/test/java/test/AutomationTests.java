package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.*;

import java.util.Random;

public class AutomationTests extends BaseTest {
    AutomationHome automationHome;
    AutomationLogin automationLogin;
    AutomationRegister automationRegister;
    AutomationAccount automationAccount;
    AutomationHomeSignIn automationHomeSignIn;
    AutomationSearch automationSearch;
    AutomationItemsFav automationItemsFav;
    AutomationRemoveItems automationRemoveItems;
    Random ran = new Random();


    @Before
    public void setUpTest(){
        automationHome = new AutomationHome();
        automationLogin = new AutomationLogin();
        automationRegister = new AutomationRegister();
        automationAccount = new AutomationAccount();
        automationHomeSignIn = new AutomationHomeSignIn();
        automationSearch = new AutomationSearch();
        automationItemsFav = new AutomationItemsFav();
        automationRemoveItems = new AutomationRemoveItems();
    }

    @Test
    public void createAccount(){
        automationHome.clickSignButton();
        automationLogin.clickRegisterButton();
        automationRegister.customerNewEmailField("lidas"+ ran.nextInt(99) +"@mail.com")
                          .customerFirstnameField("Lidija")
                          .customerPasswordField("123456789")
                          .clickRegisterAccButton();
        Assert.assertTrue(automationHomeSignIn.welcomeTextIsDIsplay());
        Assert.assertEquals("Welcome to Etsy, Lidija!", automationHomeSignIn.welcomeTextIsGet());
        automationHomeSignIn.clickAccountButton()
                            .clickSignOutButton();

    }
    @Test
    public void signInTest(){
        automationHome.clickSignButton();
        automationRegister.customerNewEmailField("lidao58@mail.com")
                          .customerPasswordField("123456789")
                          .clickLoginButton();
        Assert.assertTrue(automationHomeSignIn.welcomeTextIsDIsplay());
        Assert.assertEquals("Welcome back, Lidija!", automationHomeSignIn.welcomeTextIsGet());
        automationHomeSignIn.clickAccountButton()
                            .clickSignOutButton();
    }

    @Test
    public void searchTest(){
        automationHome.clickSignButton();
        automationRegister.customerNewEmailField("lidao58@mail.com")
                          .customerPasswordField("123456789")
                          .clickLoginButton();
        Assert.assertTrue(automationHomeSignIn.welcomeTextIsDIsplay());
        Assert.assertEquals("Welcome back, Lidija!", automationHomeSignIn.welcomeTextIsGet());
        automationHomeSignIn.setSearchField();
        js.executeScript("window.scrollBy(0,150)");
        automationSearch.clickallfiltersButton()
                        .clickCheckboxFree()
                        .clickCheckboxDays()
                        .clickCheckboxUnder()
                        .clickApplyButton();
        Assert.assertTrue(automationSearch.resultsItemIsDisplay());
        Assert.assertEquals("At Most USD 25\n" +
                "Items from Europe\n" +
                "1–3 business days\n" +
                "FREE shipping", automationSearch.resultsItemIsGetText());
        js.executeScript("window.scrollBy(0,-150)");
        automationHomeSignIn.clickAccountButton()
                            .clickSignOutButton();
    }
    @Test
    public void itemsAdd(){
        automationHome.clickSignButton();
        automationRegister.customerNewEmailField("lidao58@mail.com")
                          .customerPasswordField("123456789")
                          .clickLoginButton();
        Assert.assertTrue(automationHomeSignIn.welcomeTextIsDIsplay());
        Assert.assertEquals("Welcome back, Lidija!", automationHomeSignIn.welcomeTextIsGet());
        automationHomeSignIn.setSearchField();
        automationSearch.clickItemsTag()
                        .clickFavoritesItem()
                        .clickFavoritesItemsList();
        js.executeScript("window.scrollBy(0,150)");
        Assert.assertTrue(automationItemsFav.itemsColectionIsDisplay());
        Assert.assertEquals("Favorite items", automationItemsFav.itemsColectionIsGetText());
        js.executeScript("window.scrollBy(0,-150)");
        automationHomeSignIn.clickAccountButton()
                            .clickSignOutButton();

    }

    @Test
    public void itemsRemove(){
        automationHome.clickSignButton();
        automationRegister.customerNewEmailField("lidao58@mail.com")
                          .customerPasswordField("123456789")
                          .clickLoginButton();
        Assert.assertTrue(automationHomeSignIn.welcomeTextIsDIsplay());
        Assert.assertEquals("Welcome back, Lidija!", automationHomeSignIn.welcomeTextIsGet());
        automationHomeSignIn.setSearchField();
        automationSearch.clickItemsTag()
                        .clickFavoritesItem()
                        .clickFavoritesItemsList();
        js.executeScript("window.scrollBy(0,200)");
        automationRemoveItems.clickRemoveItemsButton();
        automationRemoveItems.clickRemoveButtonOk();
        automationRemoveItems.clickButtonDone();
        driver.navigate().refresh();
        js.executeScript("window.scrollBy(0,200)");
        Assert.assertTrue(automationRemoveItems.notingTextIsDisplay());
        Assert.assertEquals("Nothing here... yet.", automationRemoveItems.notingTextIsGet());
        js.executeScript("window.scrollBy(0,-200)");
        automationHomeSignIn.clickAccountButton()
                            .clickSignOutButton();
    }

    

}
