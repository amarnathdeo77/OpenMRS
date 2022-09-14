package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//POM for Home Page
@Getter
public class FindPatientPage {
    private WebDriver driver;

    public FindPatientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@id,'ctiveVisitsHomepageLink-extension')]")
    private WebElement PatientRegistration;

    @FindBy(xpath = "//*[@id='content']/h2")
    private WebElement FindPatientRecord;

    @FindBy(id = "patient-search")
    private WebElement FindPatientSearch;

    @FindBy(id = "patient-search-results-table")
    private WebElement PatientSearchResult;

    @FindBy(xpath = "(//*[@id='patient-search-results-table']//tr)[2]/td[2]")
    private WebElement SearchedRow;




    }
