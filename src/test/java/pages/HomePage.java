package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String url = "https://www.wafilife.com/";
    public String title = "Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";

    public By login_signup_btn = By.xpath("//a[@title='আমার অ্যাকাউন্ট']");
    public By logout_btn = By.xpath("//a[contains(text(),'লগআউট')]");
//    public By close_btn = By.xpath("//button[@class='modal_modalCloseButton__y_s5N']");

    public void loadHomePage(){
        loadPage(url);
    }

//    public By contact_us_btn = By.xpath("//a[normalize-space()='Contact us']");

}
