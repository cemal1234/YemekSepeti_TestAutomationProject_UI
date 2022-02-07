package com.crm.qa.testcases.LoginPagesTests;

import com.crm.qa.ExtendReportListener.TestAllureListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPages.CitySelectionPage;
import com.crm.qa.pages.LoginPages.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestAllureListener.class})
public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    CitySelectionPage citySelectionPage;

    public LoginPageTest() {
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

        loginPage = new LoginPage();
    }

    @Test(priority = 0,description = "login with username: {0} and password: {1} step...")
    @Severity(SeverityLevel.CRITICAL)
    public void userNameAndPasswordWithLoginTesting(){

        loginPage.userNameAndPasswordWithLogin(prop.getProperty("username"),prop.getProperty("password"));
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
