package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Util Methods to wait for web element by different ways
public class WaitUtil {
     WebDriver driver;
    public  WebDriverWait wait;

    public  WaitUtil(WebDriver driver){
        this.driver=driver;
       wait = new WebDriverWait(driver, 10);

    }

    public  void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public  void waitForElementEnabled(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public  void waitForElementSelectable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public  void sleepWait(int waitTime){
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
