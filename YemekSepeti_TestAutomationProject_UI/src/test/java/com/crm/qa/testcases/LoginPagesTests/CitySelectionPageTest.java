package com.crm.qa.testcases.LoginPagesTests;

import com.crm.qa.ExtendReportListener.TestAllureListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPages.CitySelectionPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;

@Listeners({TestAllureListener.class})
public class CitySelectionPageTest extends TestBase {

    CitySelectionPage citySelectionPage;

    public CitySelectionPageTest() {
        super();
    }


    @BeforeClass
    public void setUp(){
        initialization();

        citySelectionPage = new CitySelectionPage();
    }

    @Test(priority = 0,description = "city selection page title validation")
    @Severity(SeverityLevel.MINOR)
    public void validateCitySelectionPageTitleTesting(){
        citySelectionPage.validateCitySelectionPageTitle();
    }

    @Test(priority = 1,description = "city selection page inner header validation")
    @Severity(SeverityLevel.MINOR)
    public void validateCitySelectionPageInnerHeaderTesting(){
        citySelectionPage.validateCitySelectionPageInnerHeader();
    }

    @Test(priority = 2,description = "random city selection")
    @Severity(SeverityLevel.CRITICAL)
    public void citySelectionAndClickTesting() throws InterruptedException {
        citySelectionPage.randomCitySelectionAndClick();
    }

    @Test(priority = 3,description = "login page title validation")
    @Severity(SeverityLevel.NORMAL)
    public void validateLoginPageTitleTesting(){
        citySelectionPage.validateLoginPageTitle();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
