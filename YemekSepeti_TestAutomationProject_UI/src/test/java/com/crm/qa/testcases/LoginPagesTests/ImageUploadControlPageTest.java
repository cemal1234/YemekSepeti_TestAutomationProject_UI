package com.crm.qa.testcases.LoginPagesTests;

import com.crm.qa.ExtendReportListener.TestAllureListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPages.ImageUploadControlPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestAllureListener.class})
public class ImageUploadControlPageTest extends TestBase {

    ImageUploadControlPage imageUploadControlPage;

    public ImageUploadControlPageTest() {
        super();
    }

    @BeforeClass
    public void setUp(){
        initialization();

        imageUploadControlPage = new ImageUploadControlPage();
    }

    @Test(priority = 0,description = "image upload control page title validation")
    @Severity(SeverityLevel.MINOR)
    public void validateImageUploadControlPageTitleTesting(){
        imageUploadControlPage.validateImageUploadControlPageTitle();

    }

    @Test(priority = 1,description = "loading control of all images")
    @Severity(SeverityLevel.CRITICAL)
    public void loadingControlOfAllImagesTesting(){
        imageUploadControlPage.loadingControlOfAllImages();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
