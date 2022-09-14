package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//POM for Home Page
@Getter
public class LogoutPage {
    private WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Logout')]")
    private WebElement Logout;

    @FindBy(xpath = "//*[@id='login-form']//legend")
    private WebElement LogoutSuccess;

 }
