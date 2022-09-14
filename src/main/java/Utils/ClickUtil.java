package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



//Util methods to click web element by different ways
public class ClickUtil {
    WebDriver driver;
    WaitUtil waitUtil;
    public  JavascriptExecutor js;
    public  ClickUtil(WebDriver driver,WaitUtil waitUtil){
        this.driver=driver;
        this.waitUtil=waitUtil;
       js = (JavascriptExecutor) driver;

    }

    public  void clickElement(WebElement element) {
        waitUtil.waitForElementEnabled(element);
        element.click();
    }

    public  void clickElementWithWait(WebElement element) {
        waitUtil.sleepWait(1000);
        element.click();
    }
    public  void clickElementUsingJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }
}
