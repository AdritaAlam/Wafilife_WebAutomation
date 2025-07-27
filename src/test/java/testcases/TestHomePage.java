package testcases;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

import java.time.Duration;

public class TestHomePage extends DriverSetup {

    HomePage homepage = new HomePage();

    @BeforeMethod
    public void loadHomePageForTest(){
        homepage.loadHomePage();

    }
    @Test
    public void TestTitle(){
        Assert.assertEquals(getDriver().getTitle(),homepage.title);
    }

    @Test
    public void TestSignupButton(){
//        homepage.addScreenshot("Home page");
        homepage.clickOnElement(homepage.login_signup_btn);

        Assert.assertFalse(getDriver().getCurrentUrl().equals(homepage.url));
    }

}
