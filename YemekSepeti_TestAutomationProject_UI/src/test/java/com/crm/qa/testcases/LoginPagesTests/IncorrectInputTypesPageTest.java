package com.crm.qa.testcases.LoginPagesTests;

import com.crm.qa.ExtendReportListener.TestAllureListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPages.CitySelectionPage;
import com.crm.qa.pages.LoginPages.IncorrectInputTypesPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestAllureListener.class})
public class IncorrectInputTypesPageTest extends TestBase {

    IncorrectInputTypesPage incorrectInputTypesPage;
    CitySelectionPage citySelectionPage;

    public IncorrectInputTypesPageTest() {
        super();
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        initialization();

        citySelectionPage = new CitySelectionPage();

        citySelectionPage.validateCitySelectionPageTitle();
        citySelectionPage.validateCitySelectionPageInnerHeader();
        citySelectionPage.randomCitySelectionAndClick();
        citySelectionPage.validateLoginPageTitle();

        incorrectInputTypesPage = new IncorrectInputTypesPage();
    }

    @Test(priority = 0, description = "login with username: {0} and password: {1} step...")
    @Severity(SeverityLevel.CRITICAL)
    public void wrongUserNameWithLoginTesting() {

        incorrectInputTypesPage.wrongUserNameWithLogin(prop.getProperty("invalidUserName"), prop.getProperty("password"));
    }

    @Test(priority = 1, description = "login with username: {0} and password: {1} step...")
    @Severity(SeverityLevel.CRITICAL)
    public void wrongPasswordWithLoginTesting() {

        incorrectInputTypesPage.wrongPasswordWithLogin(prop.getProperty("username"), prop.getProperty("invalidPassword"));
    }

    @Test(priority = 2, description = "login with only password: {1} step...")
    @Severity(SeverityLevel.CRITICAL)
    public void userNameEmptyLoginTesting() {

        incorrectInputTypesPage.userNameEmptyLogin(prop.getProperty("password"));
    }

    @Test(priority = 3, description = "login with only username: {0} step...")
    @Severity(SeverityLevel.CRITICAL)
    public void passwordEmptyLoginTesting() {

        incorrectInputTypesPage.passwordEmptyLogin(prop.getProperty("username"));
    }

    @Test(priority = 4, description = "login with wrong username: {0} and password: {1} step...")
    @Severity(SeverityLevel.CRITICAL)
    public void wrongUsernameAndPasswordWithLoginTesting() {

        incorrectInputTypesPage.wrongUsernameAndPasswordWithLogin(prop.getProperty("invalidUserName"), prop.getProperty("invalidPassword"));
    }

    @Test(priority = 5, description = "login with username and password are empty")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithUsernameAndPasswordAreEmptyTesting() {

        incorrectInputTypesPage.loginWithUsernameAndPasswordAreEmpty();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
