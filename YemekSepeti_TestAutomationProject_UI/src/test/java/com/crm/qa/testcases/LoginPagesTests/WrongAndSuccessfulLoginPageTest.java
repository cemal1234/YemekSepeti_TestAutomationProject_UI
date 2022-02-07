package com.crm.qa.testcases.LoginPagesTests;

import com.crm.qa.ExtendReportListener.TestAllureListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPages.CitySelectionPage;
import com.crm.qa.pages.LoginPages.WrongAndSuccessfulLoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestAllureListener.class})
public class WrongAndSuccessfulLoginPageTest extends TestBase {

    WrongAndSuccessfulLoginPage wrongAndSuccessfulLoginPage;
    CitySelectionPage citySelectionPage;

    public WrongAndSuccessfulLoginPageTest() {
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

        wrongAndSuccessfulLoginPage = new WrongAndSuccessfulLoginPage();
    }

    @Test(priority = 0,description = "login with username: {0} and password: {1} step...")
    @Severity(SeverityLevel.CRITICAL)
    public void wrongAndSuccessfulLoginTesting(){

        wrongAndSuccessfulLoginPage.wrongUsernameThenSuccessfulLogin(prop.getProperty("invalidUserName"),prop.getProperty("password"));
    }

    @Test(priority = 1,description = "Retry login with username: {0} and password: {1} step...")
    @Severity(SeverityLevel.CRITICAL)
    public void correctUsernameWithLoginTesting(){

        wrongAndSuccessfulLoginPage.correctUsernameWithLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
