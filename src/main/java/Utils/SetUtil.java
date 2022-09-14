package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//Util Methods to send keys to web element by different ways
public class SetUtil {
    WebDriver driver;
    WaitUtil waitUtil;
    public  SetUtil(WebDriver driver,WaitUtil waitUtil){
        this.driver=driver;
        this.waitUtil=waitUtil;

    }

    public  void setElement(WebElement element, String value) {
        waitUtil.waitForElement(element);
        element.sendKeys(value);
    }

    public  void selectElement(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
}
