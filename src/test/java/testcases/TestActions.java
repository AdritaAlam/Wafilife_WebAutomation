package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        homePage.addScreenshot("Home page");
        homePage.clickOnElement(homePage.login_signup_btn);

    }

    @Test(description = "Test Login-Signup and different actions after login")
    public void testDiffActions() throws InterruptedException {

        homePage.addScreenshot("Login page");
        loginpage.writeOnElement(loginpage.login_email,"your email");
        loginpage.writeOnElement(loginpage.password,"password");
        loginpage.clickOnElement(loginpage.login_btn);
        homePage.addScreenshot("Home page");
        Assert.assertTrue(homePage.isVisible(homePage.logout_btn));
        Assert.assertFalse(loginpage.isVisible(loginpage.login_btn));


        Actions actions = new Actions(getDriver());

        homePage.clickOnElement(By.xpath("//span[contains(text(),'লেখক')]"));


        // Scrolling and moving to the next page
        actions.scrollByAmount(0,1000).build().perform();
        homePage.addScreenshot("Scrolling down");
        homePage.clickOnElement(By.xpath("//a[contains(text(),'→')]"));

        // Selecting author and order any book
        homePage.addScreenshot("Author selection");
        homePage.clickOnElement(By.xpath("//h3[normalize-space()='Mark Twain']"));
        homePage.addScreenshot("Details of the book");
        homePage.clickOnElement(By.xpath("//img[@title='Adventure-of-Hackle-Bari-Feen']"));
        homePage.clickOnElement(By.xpath("//button[@class='single_add_to_cart_button button alt ']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement orderCompleteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'অর্ডার সম্পন্ন করুন')]")
        ));

        homePage.clickOnElement(By.xpath("//span[contains(text(),'অর্ডার সম্পন্ন করুন')]"));
        homePage.addScreenshot("Confirm order");

        // billing info
        billinfo.writeOnElement(billinfo.user_name,"");
        billinfo.writeOnElement(billinfo.phone_number,"");
        billinfo.writeOnElement(billinfo.email,"");

        // dropdown
        getDriver().findElement(By.id("select2-billing_state-container")).click();

        // Type in the search box inside Select
        WebElement districtSearchBox = getDriver().findElement(By.xpath("//input[@class='select2-search__field']"));
        districtSearchBox.sendKeys("Rajshahi");
        districtSearchBox.sendKeys(Keys.ENTER);


        // Wait until old area dropdown is removed/reloaded
        WebDriverWait wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait2.until(ExpectedConditions.stalenessOf(getDriver().findElement(By.id("billing_area"))));

        // Wait for new area dropdown to appear and contain Rajshahi City
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("billing_area")));
        wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.id("billing_area"), "রাজশাহী সিটি"));

        // Select Rajshahi City
        Select area = new Select(getDriver().findElement(By.id("billing_area")));
        area.selectByVisibleText("রাজশাহী সিটি");
        Thread.sleep(2000);


        billinfo.writeOnElement(billinfo.address,"*******");
        WebElement radioButton = getDriver().findElement(By.xpath("//input[@id='payment_method_bkash']"));
        System.out.println("Bkash payment(Before clicked): "+ radioButton.isSelected());
        radioButton.click();
        Thread.sleep(7000);
        System.out.println("Bkash payment (After clicked): "+ radioButton.isSelected());
        homePage.addScreenshot("Billing info");
        Thread.sleep(4000);

        //logout
        actions.scrollByAmount(0,-1000);
        loginpage.clickOnElement(loginpage.my_account);
        Thread.sleep(4000);
        loginpage.clickOnElement(loginpage.logout_btn);
        homePage.addScreenshot("Logout(After)");


    }
}
