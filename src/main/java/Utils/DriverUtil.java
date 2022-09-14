package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//Singleton class to initialise the browser instance
public class DriverUtil {
    private  WebDriver driver=null;
    public static String browser = System.getProperty("browser", JsonInputParser.configDataInit().get("browser").toString());

    public DriverUtil() {

    }

    public  WebDriver init() {
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if (browser.equalsIgnoreCase("FF")) {
                {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
            }
        }
        return driver;
    }

}
