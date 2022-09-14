package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//POM for Home Page
@Getter
public class ViewPatientPage {
    private WebDriver driver;

    public ViewPatientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='PersonName-givenName']")
    private WebElement FirstName;

    @FindBy(xpath = "//*[@class='contact-info-inline labeled']//span")
    private WebElement Address;


    @FindBy(xpath = "//*[@class='PersonName-middleName']")
    private WebElement MiddleName;

    @FindBy(xpath = "//*[@class='PersonName-familyName']")
    private WebElement FamilyName;

    @FindBy(id ="coreapps-showContactInfo")
    private WebElement ShowContactInfo;

    @FindBy(id = "coreapps-telephoneNumber")
    private WebElement PhoneNumber;

    }
