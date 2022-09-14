package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


//Util methods to click web element by different ways
public class VerifyUtil {
    WebDriver driver;
    VerifyUtil verifyUtil;
    public JavascriptExecutor js;

    public VerifyUtil(WebDriver driver, VerifyUtil verifyUtil) {
        this.driver = driver;
        this.verifyUtil = verifyUtil;
        js = (JavascriptExecutor) driver;

    }


    public void verifyText(WebElement element, String textValue) {
        Assert.assertEquals(element.getText(), textValue);
    }

    // Method to verify Search Records
    public void validatePatientRecord(WebElement table,String columnName, String expectedSearchResult){
        List<WebElement> tableRows = table.findElements(By.xpath("//*[@id='patient-search-results-table']/tbody/tr"));
        System.out.println("Col name is " +columnName);
        int searchedColIndex = table.findElements(By.xpath("//thead/tr/th/div[text()='"+columnName+"/../preceding-sibling::th']")).size()+2;
        List<String> returnedVals = new ArrayList<String>();
        System.out.println("searchedColIndex size is " +searchedColIndex);

        for (int i = 1; i < tableRows.size(); i++) {
            String returnedVal = table.findElement(By.xpath("./tbody/tr["+i+"]/td["+searchedColIndex+"]")).getText();
            System.out.println("Returned val is "+returnedVal);
            returnedVals.add(returnedVal);
        }
        Assert.assertTrue(returnedVals.contains(expectedSearchResult));
    }

}