package com.crm.qa.pages.FavoriteRestaurantPages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToFavoriteWithSearchPage extends TestBase {

    /** Add To Favorite With Search Page Locators: **/

    @FindBy(id = "select2-ys-areaSelector-container")
    WebElement selectDistrictComboBox;

    @FindBy(xpath = "//li[contains(text(),'Tüm Semtler')]")
    WebElement selectAllDistrict;

    @FindBy(xpath = "//button[@class='form-control ys-btn ys-btn-default search-button']")
    WebElement searchButton;

    @FindBy(className = "ys-result-count")
    WebElement restaurantResults;

    @FindBy(xpath = "(//*[@class='ys-reslist-items']//div[@class='restaurant-display-name'])[1]")
    WebElement firstRestaurantSelect;

    @FindBy(className = "close-alternative-popup")
    WebElement alternativePopUp;

    // Initializing the Page Objects:
    public AddToFavoriteWithSearchPage(){
        PageFactory.initElements(driver,this);
    }

    /** Actions: **/

    @Step("select district and search")
    public void selectDistrictAndSearch(){
        System.out.println("Tüm Restorantlar Listeleniyor..");

        clickFunction(selectDistrictComboBox);
        clickFunction(selectAllDistrict);
        clickFunction(searchButton);
        elementVisibilityWait(restaurantResults);
        clickFunction(firstRestaurantSelect);

        if(alternativePopUp.isDisplayed()){
            clickFunction(alternativePopUp);
        }

        System.out.println("Seçilen Restorant: " + driver.getTitle());
        System.out.println("Restorant Favorilere Eklenecek..");

    }
}
