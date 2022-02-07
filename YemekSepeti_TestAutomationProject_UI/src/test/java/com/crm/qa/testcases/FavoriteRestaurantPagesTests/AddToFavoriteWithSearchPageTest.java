package com.crm.qa.testcases.FavoriteRestaurantPagesTests;

import com.crm.qa.ExtendReportListener.TestAllureListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FavoriteRestaurantPages.AddAndRemoweToFavoritePage;
import com.crm.qa.pages.FavoriteRestaurantPages.AddToFavoriteWithSearchPage;
import com.crm.qa.pages.FavoriteRestaurantPages.CheckAndDeleteFavoritePage;
import com.crm.qa.pages.LoginPages.CitySelectionPage;
import com.crm.qa.pages.LoginPages.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestAllureListener.class})
public class AddToFavoriteWithSearchPageTest extends TestBase {

    CitySelectionPage citySelectionPage;
    LoginPage loginPage;
    AddAndRemoweToFavoritePage addAndRemoweToFavoritePage;
    CheckAndDeleteFavoritePage checkAndDeleteFavoritePage;
    AddToFavoriteWithSearchPage addToFavoriteWithSearchPage;

    public AddToFavoriteWithSearchPageTest(){
        super();
    }

    @BeforeClass
    public void setUp(){
        initialization();

        citySelectionPage = new CitySelectionPage();
        loginPage = new LoginPage();
        addAndRemoweToFavoritePage = new AddAndRemoweToFavoritePage();
        checkAndDeleteFavoritePage = new CheckAndDeleteFavoritePage();
        addToFavoriteWithSearchPage = new AddToFavoriteWithSearchPage();
    }

    @Test(priority = 0,description = "city select and login transactions")
    @Severity(SeverityLevel.NORMAL)
    public void citySelectAndLoginTransactionsTesting() throws InterruptedException {

        citySelectionPage.validateCitySelectionPageTitle();
        citySelectionPage.validateCitySelectionPageInnerHeader();
        citySelectionPage.randomCitySelectionAndClick();
        citySelectionPage.validateLoginPageTitle();

        loginPage.userNameAndPasswordWithLogin(prop.getProperty("username"),prop.getProperty("password"));

    }

    @Test(priority = 1,description = "select district and search")
    @Severity(SeverityLevel.NORMAL)
    public void selectDistrictAndSearchTesting() {
        addToFavoriteWithSearchPage.selectDistrictAndSearch();
    }

    @Test(priority = 2,description = "add new restaurant to favorite")
    @Severity(SeverityLevel.NORMAL)
    public void addToFavoriteTesting() {
        addAndRemoweToFavoritePage.addToFavorite();
    }

    @Test(priority = 3,description = "go to my favorites")
    @Severity(SeverityLevel.NORMAL)
    public void goToMyFavoritesTesting(){
        checkAndDeleteFavoritePage.goToMyFavorites();
    }

    @Test(priority = 4,description = "check and delete my favorites")
    @Severity(SeverityLevel.CRITICAL)
    public void checkAndDeleteMyFavoritesTesting(){
        checkAndDeleteFavoritePage.checkAndDeleteMyFavorites();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
