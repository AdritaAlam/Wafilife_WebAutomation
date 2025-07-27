package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverSetup;

import static utilities.DriverSetup.getDriver;

public class LoginPage extends BasePage {

    public String url = "https://www.rokomari.com/login";

    public By password = By.xpath("//input[@id='password']");
    public By login_email = By.xpath("//input[@id='username']");
    public By login_btn = By.xpath("//input[@name='login']");

    public By my_account = By.xpath("//div[@class='login-links']//a[@title='আমার অ্যাকাউন্ট'][contains(text(),'আমার অ্যাকাউন্ট')]");
    public By logout_btn = By.xpath("//a[contains(text(),'লগআউট')]");

    public By empty_user = By.xpath("//li[contains(text(),'ইউজার নাম প্রয়োজন')]");
    public By empty_pass = By.xpath("//div[@id='main-module-container']//li[1]");
    public By empty_both = By.xpath("//li[contains(text(),'ইউজার নাম প্রয়োজন')]");
    public By invalid_both = By.xpath("//li[contains(text(),'Unknown email address. Check again or try your use')]");

}
