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

    HomePage homePage = new HomePage();
    LoginPage loginpage = new LoginPage();

    @BeforeMethod
    public void loadHomePageForTest() {
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.login_signup_btn);
    }

    @Test(description = "Test Login-page with valid credentials")
    public void TestLoginWithValidCredentials() {

        loginpage.writeOnElement(loginpage.login_email,"adritaalam.prima@gmail.com");
        loginpage.writeOnElement(loginpage.password,"********");
        loginpage.clickOnElement(loginpage.login_btn);
        homePage.addScreenshot("Login page");
        Assert.assertTrue(homePage.isVisible(homePage.logout_btn));
        Assert.assertFalse(loginpage.isVisible(loginpage.login_btn));
    }

    @Test(description = "Test Login-page with invalid credentials using Dataset", dataProvider = "invalidUserCredentials(DataDriven)", dataProviderClass = DataSet.class)
    public void TestLoginWithInvalidCredentialsWithDataDriven(String email, String password, String error_msg,String validation_msg){
        loginpage.writeOnElement(loginpage.login_email,email);
        loginpage.writeOnElement(loginpage.password,password);
        loginpage.clickOnElement(loginpage.login_btn);

        if (email.isEmpty()){
            Assert.assertEquals(loginpage.getElement(loginpage.login_email).getAttribute("textContent"),validation_msg);
        }
        if (password.isEmpty()){
            Assert.assertEquals(loginpage.getElement(loginpage.password).getAttribute("textContent"),validation_msg);
        }
        homePage.addScreenshot("Error msg for Invalid Credentials");

    }
}
