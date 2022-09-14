package tests;

import Base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenmrsTest extends BaseTest {

    @BeforeMethod(description = "method to load the url before every test case")
    public void beforeClass() {
        this.driver.get(config.get("url").toString());
    }

    @Test(description = "Login into application")
    public void LoginTest() {
        JSONObject testData = (JSONObject) data.get(testCaseName);
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getUsername(), config.get("Username").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getPassword(), config.get("Password").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLocOfPatient());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLoginBtn());
        //Verify Login successful
        pageObjectManager.verifyUtil.verifyText(pageObjectManager.homePage.getLoginSuccess(), testData.get("SuccessMsg").toString());

    }

    @Test(description = "Register a Patient")
    public void PatientRegistrationTest() {
        JSONObject testData = (JSONObject) data.get(testCaseName);
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getUsername(), config.get("Username").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getPassword(), config.get("Password").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLocOfPatient());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLoginBtn());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.registerPatientPage.getPatientRegistration());
        pageObjectManager.setUtil.setElement(pageObjectManager.registerPatientPage.getGivenName(), testData.get("GivenName").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.registerPatientPage.getMiddleName(), testData.get("MiddleName").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.registerPatientPage.getFamilyName(), testData.get("FamilyName").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.registerPatientPage.getNextBtn());
        pageObjectManager.setUtil.setElement(pageObjectManager.registerPatientPage.getGender(),"Male");
        pageObjectManager.clickUtil.clickElement(pageObjectManager.registerPatientPage.getNextBtn());
        pageObjectManager.setUtil.setElement(pageObjectManager.registerPatientPage.getBirthYear(),testData.get("BirthYear").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.registerPatientPage.getBirthMonth(),testData.get("BirthMonth").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.registerPatientPage.getNextBtn());
        pageObjectManager.setUtil.setElement(pageObjectManager.registerPatientPage.getAddress(),testData.get("Address").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.registerPatientPage.getNextBtn());
        pageObjectManager.setUtil.setElement(pageObjectManager.registerPatientPage.getPhoneNumber(),testData.get("Phone").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.registerPatientPage.getNextBtn());
        pageObjectManager.setUtil.setElement(pageObjectManager.registerPatientPage.getRelationShipType(),testData.get("RelationShipType").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.registerPatientPage.getRelationShip(),testData.get("RelationShipName").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.registerPatientPage.getNextBtn());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.registerPatientPage.getSubmitBtn());
        pageObjectManager.waitUtil.waitForElement(pageObjectManager.registerPatientPage.getConfirmPatient());
        // Verify Patient getting added
        pageObjectManager.verifyUtil.verifyText(pageObjectManager.registerPatientPage.getConfirmPatient(),testData.get("GivenName").toString());
    }

    @Test(description = "Find a Patient from available list")
    public void FindPatient() {
        JSONObject testData = (JSONObject) data.get(testCaseName);
        JSONObject registrationData = (JSONObject) data.get("PatientRegistrationTest");
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getUsername(), config.get("Username").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getPassword(), config.get("Password").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLocOfPatient());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLoginBtn());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.findPatientPage.getPatientRegistration());
        pageObjectManager.verifyUtil.verifyText(pageObjectManager.findPatientPage.getFindPatientRecord(),testData.get("FindPatientHeading").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.findPatientPage.getFindPatientSearch(),registrationData.get("GivenName")+" "+registrationData.get("MiddleName")+" "+registrationData.get("FamilyName"));
        //Verify Search Result
        pageObjectManager.verifyUtil.validatePatientRecord(pageObjectManager.findPatientPage.getPatientSearchResult(), "Name",testData.get("GivenName").toString());
    }

    @Test(description = "Find a Patient from available list")
    public void ViewPatient() {
        JSONObject testData = (JSONObject) data.get(testCaseName);
        JSONObject registrationData = (JSONObject) data.get("PatientRegistrationTest");
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getUsername(), config.get("Username").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getPassword(), config.get("Password").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLocOfPatient());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLoginBtn());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.findPatientPage.getPatientRegistration());
        pageObjectManager.setUtil.setElement(pageObjectManager.findPatientPage.getFindPatientSearch(),registrationData.get("GivenName")+" "+registrationData.get("MiddleName")+" "+registrationData.get("FamilyName")+"");
        pageObjectManager.waitUtil.sleepWait(3000);
        pageObjectManager.clickUtil.clickElement(pageObjectManager.findPatientPage.getSearchedRow());
        //Verifying added details on view page
        pageObjectManager.clickUtil.clickElement(pageObjectManager.viewPatientPage.getShowContactInfo());
        pageObjectManager.verifyUtil.verifyText(pageObjectManager.viewPatientPage.getFirstName(),registrationData.get("GivenName").toString());
        pageObjectManager.verifyUtil.verifyText(pageObjectManager.viewPatientPage.getMiddleName(),registrationData.get("MiddleName").toString());
        pageObjectManager.verifyUtil.verifyText(pageObjectManager.viewPatientPage.getFamilyName(),registrationData.get("FamilyName").toString());
        Assert.assertTrue(pageObjectManager.viewPatientPage.getAddress().getText().contains(registrationData.get("Address").toString()), "Address verification failed");
        pageObjectManager.verifyUtil.verifyText(pageObjectManager.viewPatientPage.getPhoneNumber(),registrationData.get("Phone").toString());
    }

    @Test(description = "Find a Patient from available list")
    public void DeletePatient() {
        JSONObject testData = (JSONObject) data.get(testCaseName);
        JSONObject registrationData = (JSONObject) data.get("PatientRegistrationTest");
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getUsername(), config.get("Username").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getPassword(), config.get("Password").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLocOfPatient());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLoginBtn());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.findPatientPage.getPatientRegistration());
        pageObjectManager.setUtil.setElement(pageObjectManager.findPatientPage.getFindPatientSearch(),registrationData.get("GivenName")+" "+registrationData.get("MiddleName")+" "+registrationData.get("FamilyName"));
        pageObjectManager.clickUtil.clickElement(pageObjectManager.deletePatientPage.getSelectRecord());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.deletePatientPage.getDeletePatientRecord());
        pageObjectManager.setUtil.setElement(pageObjectManager.deletePatientPage.getDeleteConfirmationText(),"Test");
        pageObjectManager.clickUtil.clickElement(pageObjectManager.deletePatientPage.getDeleteConfirm());
        pageObjectManager.waitUtil.sleepWait(3000);
        Assert.assertTrue(pageObjectManager.deletePatientPage.getFindRecordHeader().isDisplayed(), "Find patients page is displayed");

    }

    @Test(description = "Logout from Application")
    public void LogOut() {
        JSONObject testData = (JSONObject) data.get(testCaseName);
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getUsername(), config.get("Username").toString());
        pageObjectManager.setUtil.setElement(pageObjectManager.loginPage.getPassword(), config.get("Password").toString());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLocOfPatient());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.loginPage.getLoginBtn());
        pageObjectManager.waitUtil.waitForElement(pageObjectManager.logoutPage.getLogout());
        pageObjectManager.clickUtil.clickElement(pageObjectManager.logoutPage.getLogout());
        //Verify Logout successful
        pageObjectManager.verifyUtil.verifyText(pageObjectManager.logoutPage.getLogoutSuccess(),"LOGIN");

    }
}
