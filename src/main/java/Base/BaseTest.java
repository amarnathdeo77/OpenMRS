package Base;

import Utils.DriverUtil;
import Utils.JsonInputParser;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.PageObjectManager;


import java.lang.reflect.Method;

public class BaseTest {

    public  WebDriver driver =new DriverUtil().init();
    public String testCaseName;
    public JSONObject data;
     public JSONObject config;
     public static PageObjectManager pageObjectManager=null;

    @BeforeTest(description = "set up method to maximize the browser and init the json parsers")
    public void setUp() {
        driver.manage().window().maximize();
        pageObjectManager=new PageObjectManager(driver);
        data = JsonInputParser.inputDataInit();
        config = JsonInputParser.configDataInit();
    }

    @BeforeMethod(description = "method to get the test case name to get the corresponding input data from JSON")
    public void handleTestMethodName(Method method) {
        testCaseName = method.getName();
    }

    @AfterTest(description = "method to close the driver instance")
    public void tearDown() {
        driver.close();
    }
}
