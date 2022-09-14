package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//POM for Home Page
@Getter
public class RegisterPatientPage {
    private WebDriver driver;

    public RegisterPatientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@id,'referenceapplication-registrationapp')]")
    private WebElement PatientRegistration;

    @FindBy(name = "givenName")
    private WebElement GivenName;

    @FindBy(name = "middleName")
    private WebElement MiddleName;

    @FindBy(name = "familyName")
    private WebElement FamilyName;

    @FindBy(id = "next-button")
    private WebElement NextBtn;

    @FindBy(xpath = "//*[@id=\"gender-field\"]")
    private WebElement Gender;

    @FindBy(id = "birthdateYears-field")
    private WebElement BirthYear;

    @FindBy(id = "birthdateMonths-field")
    private WebElement BirthMonth;

    @FindBy(id = "address1")
    private WebElement Address;

    @FindBy(name = "phoneNumber")
    private WebElement PhoneNumber;

    @FindBy(id = "relationship_type")
    private WebElement RelationShipType;

    @FindBy(xpath = "//*[contains(@ng-model,'relationship.name')]")
    private WebElement RelationShip;

    @FindBy(id = "submit")
    private WebElement SubmitBtn;

    @FindBy(xpath = "//*[@class='PersonName-givenName']")
    private WebElement ConfirmPatient;

    }
