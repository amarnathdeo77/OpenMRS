package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//POM for Home Page
@Getter
public class DeletePatientPage {
    private WebDriver driver;

    public DeletePatientPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"patient-search-results-table\"]/tbody/tr[1]/td[2]")
    private WebElement SelectRecord;

    @FindBy(xpath = "//div[contains(text(),'Delete Patient')]")
    private WebElement DeletePatientRecord;

    @FindBy(id = "delete-reason")
    private WebElement DeleteConfirmationText;

    @FindBy(xpath = "//i[@class='icon-remove']/../..//button[@class='confirm right']")
    private WebElement DeleteConfirm;

    @FindBy(xpath = "//h2[contains(text(),'Find Patient Record')]")
    private WebElement FindRecordHeader;




    }
