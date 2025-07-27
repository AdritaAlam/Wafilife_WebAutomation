package pages;

import org.openqa.selenium.By;

public class BillingInfoPage extends BasePage{
    public String url = "https://www.rokomari.com/login";

    public By user_name = By.xpath("//input[@id='billing_first_name']");
    public By phone_number = By.xpath("//input[@id='billing_phone']");
    public By email = By.xpath("//input[@id='billing_email']");
    public By district = By.xpath("//div[@id='tboj2dpcn6v81753603460838']");
    public By combo = By.xpath("//input[@role='combobox']");
    public By area = By.xpath("");
    public By address = By.xpath("//textarea[@id='billing_address_1']");
    public By payment = By.xpath("//input[@name='login']");
}
