package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BillingInfoPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

import java.time.Duration;

public class TestActions extends DriverSetup {

    HomePage homePage = new HomePage();
    LoginPage loginpage = new LoginPage();
    BillingInfoPage billinfo = new BillingInfoPage();

    @BeforeMethod
    public void loadHomePageForTest() {
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.login_signup_btn);
    }

    @Test
    public void testDiffActions() {

        loginpage.writeOnElement(loginpage.login_email,"adritaalam.prima@gmail.com");
        loginpage.writeOnElement(loginpage.password,"********");
        loginpage.clickOnElement(loginpage.login_btn);
        homePage.addScreenshot("Login page");
        Assert.assertTrue(homePage.isVisible(homePage.logout_btn));
        Assert.assertFalse(loginpage.isVisible(loginpage.login_btn));





//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//        Actions actions = new Actions(driver);
        Actions actions = new Actions(getDriver());

        homePage.clickOnElement(By.xpath("//span[contains(text(),'লেখক')]"));



        // SCROLL
        actions.scrollByAmount(0,1000).build().perform();
        homePage.clickOnElement(By.xpath("//a[contains(text(),'→')]"));

        homePage.clickOnElement(By.xpath("//h3[normalize-space()='Mark Twain']"));
        homePage.clickOnElement(By.xpath("//img[@title='Adventure-of-Hackle-Bari-Feen']"));
        homePage.clickOnElement(By.xpath("//button[@class='single_add_to_cart_button button alt ']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement orderCompleteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'অর্ডার সম্পন্ন করুন')]")
        ));
        homePage.clickOnElement(By.xpath("//span[contains(text(),'অর্ডার সম্পন্ন করুন')]"));

        billinfo.writeOnElement(billinfo.user_name,"Prima");
        billinfo.writeOnElement(billinfo.phone_number,"01733331392");
        billinfo.writeOnElement(billinfo.email,"adritaalam.prima@gmail.com");
//        WebElement selectElement = getDriver().findElement(By.id("select2-billing_state-container"));
//        Select select = new Select(selectElement);
////        billinfo.writeOnElement(billinfo.combo,"Raj");
//        select.selectByValue("Rajshahi");
////        actions.scrollByAmount(0,1000).build().perform();
//
////        billinfo.writeOnElement(billinfo.district,"adritaalam.prima@gmail.com");
//        billinfo.writeOnElement(billinfo.area,"********");
////        billinfo.writeOnElement(billinfo.address,);

//        billinfo.addScreenshot("Login page");

//        actions.scrollToElement().build().perform();
//        Thread.sleep(3000);


    }
}
