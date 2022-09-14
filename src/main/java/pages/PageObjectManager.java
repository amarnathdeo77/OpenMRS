package pages;

import Utils.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public  LoginPage loginPage;
    public  HomePage homePage;
    public RegisterPatientPage registerPatientPage;
    public FindPatientPage findPatientPage;
    public ViewPatientPage viewPatientPage;
    public DeletePatientPage deletePatientPage;
    public LogoutPage logoutPage;
    public  ClickUtil clickUtil;
    public  JsonInputParser jsonInputParser;
   public  SetUtil setUtil;
    public  VerifyUtil verifyUtil;
    public WaitUtil waitUtil;
    public PageObjectManager(WebDriver driver){
        this.driver=driver;
        loginPage=new LoginPage(this.driver);
        homePage = new HomePage(this.driver);
        registerPatientPage =new RegisterPatientPage(this.driver);
        findPatientPage =new FindPatientPage(this.driver);
        viewPatientPage =new ViewPatientPage(this.driver);
        deletePatientPage =new DeletePatientPage(this.driver);
        logoutPage =new LogoutPage(this.driver);
        waitUtil= new WaitUtil(this.driver);
        clickUtil= new ClickUtil(this.driver,waitUtil);
        jsonInputParser= new JsonInputParser();
        verifyUtil= new VerifyUtil(this.driver,verifyUtil);
        setUtil= new SetUtil(this.driver,waitUtil);

    }



}
