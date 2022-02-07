package com.crm.qa.pages.FavoriteRestaurantPages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckAndDeleteFavoritePage extends TestBase {

    /** Add New Restaurant To Favorite Page Locators: **/

    @FindBy(id = "ysUserName")
    WebElement userNameDropDown;

    @FindBy(xpath = "//a[contains(text(),'Favorilerim')]")
    WebElement myFavoritesButton;

    By addedfavoriteButtonControl = By.xpath("//b[contains(text(),'Favorilerden Çıkar')]");

    @FindBy(xpath = "(//input[@name='SelectedFavoriteRestaurantIds'][1])")
    WebElement favoriteCheckBox;

    @FindBy(xpath = "(//button[contains(text(),'SİL')][1])")
    WebElement favoriteDeleteButton;

    @FindBy(xpath = "//p[contains(text(),'Henüz favori restoranınız bulunmamaktadır.')]")
    WebElement controlOfDeletedFavorite;

    /** Initializing the Page Objects: **/

    public CheckAndDeleteFavoritePage(){
        PageFactory.initElements(driver,this);
    }

    /** Actions: **/

    @Step("go to my favorites")
    public void goToMyFavorites(){
        System.out.println("Favorilerime Gidiliyor..");
        clickFunction(userNameDropDown);
        clickFunction(myFavoritesButton);
        elementInvisibilityWait(addedfavoriteButtonControl);

        pageTitleControl("Favorilerim - Yemek Sepeti");

    }

    @Step("check and delete my favorites")
    public void checkAndDeleteMyFavorites(){
        System.out.println("Favori CheckBox Seçiliyor..");
        clickFunction(favoriteCheckBox);
        clickFunction(favoriteDeleteButton);
        System.out.println("Silinen Favorinin Kontrolü Yapılıyor..");

        ObjectTextControl(controlOfDeletedFavorite,"Henüz favori restoranınız bulunmamaktadır.");

    }
}
