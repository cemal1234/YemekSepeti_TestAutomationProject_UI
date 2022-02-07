package com.crm.qa.testcases.LoginPagesTests;

import com.crm.qa.ExtendReportListener.TestAllureListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPages.CitySelectionPage;
import com.crm.qa.pages.LoginPages.IForgotMyPasswordPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestAllureListener.class})
public class IForgotMyPasswordPageTest extends TestBase {

    IForgotMyPasswordPage iForgotMyPasswordPage;
    CitySelectionPage citySelectionPage;

    public IForgotMyPasswordPageTest() {
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

        iForgotMyPasswordPage = new IForgotMyPasswordPage();
    }

    @Test(priority = 0, description = "i forgot my password and valid email send page")
    @Severity(SeverityLevel.CRITICAL)
    public void iForgotMyPasswordAndValidEmailSendPage() {
        iForgotMyPasswordPage.iForgotMyPasswordAndValidEmailSendPage();
    }

    @Test(priority = 1, description = "password reset email message is verified")
    @Severity(SeverityLevel.NORMAL)
    public void passwordResetEmailMessageIsVerifiedTesting() {
        iForgotMyPasswordPage.passwordResetEmailMessageIsVerified();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
