package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//POM for Home Page
@Getter
public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement Username;

    @FindBy(id = "password")
    private WebElement Password;

    @FindBy(xpath = "//*[@id=\"Inpatient Ward\"]")
    private WebElement LocOfPatient;

    @FindBy(id = "loginButton")
    private WebElement LoginBtn;




}
