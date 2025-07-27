package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {
//    By iframe_section = By.xpath("//a[contains(text(),'→')]");

    HomePage homePage = new HomePage();
    LoginPage loginpage = new LoginPage();

    @BeforeMethod
    public void loadHomePageForTest() {
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.login_signup_btn);
    }

    @Test
    public void TestLoginWithValidCredentials() {

        loginpage.writeOnElement(loginpage.login_email,"adritaalam.prima@gmail.com");
        loginpage.writeOnElement(loginpage.password,"********");
        loginpage.clickOnElement(loginpage.login_btn);
        homePage.addScreenshot("Login page");
        Assert.assertTrue(homePage.isVisible(homePage.logout_btn));
        Assert.assertFalse(loginpage.isVisible(loginpage.login_btn));
    }



}
