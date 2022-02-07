package com.crm.qa.testcases.FavoriteRestaurantPagesTests;

import com.crm.qa.ExtendReportListener.TestAllureListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FavoriteRestaurantPages.AddAndRemoweToFavoritePage;
import com.crm.qa.pages.LoginPages.CitySelectionPage;
import com.crm.qa.pages.LoginPages.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;

@Listeners({TestAllureListener.class})
public class AddAndRemoweToFavoritePageTest extends TestBase {

    AddAndRemoweToFavoritePage addAndRemoweToFavoritePage;
    CitySelectionPage citySelectionPage;
    LoginPage loginPage;

    public AddAndRemoweToFavoritePageTest(){
        super();
    }

    @BeforeClass
    public void setUp(){
        initialization();

        citySelectionPage = new CitySelectionPage();
        loginPage = new LoginPage();
        addAndRemoweToFavoritePage = new AddAndRemoweToFavoritePage();

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

    @Test(priority = 1,description = "random restaurant selection")
    @Severity(SeverityLevel.NORMAL)
    public void randomRestaurantSelectionTesting() throws InterruptedException {
        addAndRemoweToFavoritePage.randomRestaurantSelection();
    }

    @Test(priority = 2,description = "add new restaurant to favorite")
    @Severity(SeverityLevel.NORMAL)
    public void addToFavoriteTesting(){
        addAndRemoweToFavoritePage.addToFavorite();
    }

    @Test(priority = 3,description = "remove from favorites")
    @Severity(SeverityLevel.NORMAL)
    public void removeFromFavorites(){
        addAndRemoweToFavoritePage.removeFromFavorites();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
