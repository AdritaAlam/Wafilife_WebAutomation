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

//    public By error_msg = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");
//
//    public String user_email = "";
//    public String user_password = "1234";

//    public By signupWithGoogle = By.xpath("//button[normalize-space()='Google']");



}
