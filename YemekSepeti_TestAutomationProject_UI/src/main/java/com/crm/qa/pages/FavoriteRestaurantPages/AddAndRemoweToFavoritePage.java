package com.crm.qa.pages.FavoriteRestaurantPages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddAndRemoweToFavoritePage extends TestBase {

    /** Add New Restaurant To Favorite Page Locators: **/

    @FindBy(xpath = "//a[@data-content-id='new-restaurants']")
    WebElement newRestaurantButton;

    @FindBy(xpath = "//div[@id='new-restaurants']/div[@class='ys-po-item po-item-line']//a/span")
    List<WebElement> randomFavoriteList;

    @FindBy(xpath = "//div[@id='new-restaurants']/div[@class='ys-po-item po-item-line']//a/span")
    WebElement randomFavoriteListVariable;

    @FindBy(xpath = "//b[contains(text(),'Favorilere Ekle')]")
    WebElement favoriteButton;

    @FindBy(xpath = "//b[contains(text(),'Favorilerden Çıkar')]")
    WebElement addedfavoriteButton;

    @FindBy(xpath = "//span[contains(text(),'ŞEHİR DEĞİŞTİR ')]")
    WebElement changeCityButton;

    By userNameCheck = By.id("ysUserName");

    @FindBy(xpath = "//div[@class='innerHeader']/h1")
    WebElement loginPageTextControl;

    @FindBy(xpath = "//div[@class='cityPlatesContainer']//div[@class='cityContainer']")
    List<WebElement> randomCityList;

    By invisibleImageControl = By.className("cityPlatesContainer");

    /** Initializing the Page Objects: **/

    public AddAndRemoweToFavoritePage(){
        PageFactory.initElements(driver,this);
    }

    /** Actions **/

    @Step("random restaurant selection")
    public void randomRestaurantSelection() throws InterruptedException {
        clickFunction(newRestaurantButton);

        if (!randomFavoriteListVariable.isDisplayed()) {

            System.out.println("Seçmiş olduğunuz semtte yakın zamanda açılmış bir restoran bulunmamaktadır.");
            System.out.println("Yeni Şehir Seçimi Yapılıyor..");

            clickFunction(changeCityButton);
            elementInvisibilityWait(userNameCheck);
            ObjectTextControl(loginPageTextControl, "Yemeksepeti'yle yemeğin sadece birkaç tık uzaklıkta! Şehrinizi seçip sipariş verin.");
            elementsVisibilityWait(randomCityList);
            randomCitySelect(randomCityList);
            elementInvisibilityWait(invisibleImageControl);
            cityVerify(driver.getTitle());
            clickFunction(newRestaurantButton);

        }

        System.out.println("Seçilen Semtte Yeni Restorant Var, Seçim Yapılıyor..");
        randomRestaurantSelect(randomFavoriteList);
        System.out.println("Random Restorant'a tıklandı."+"\n");
    }

    @Step("add new restaurant to favorite")
    public void addToFavorite(){
        clickFunction(favoriteButton);
        System.out.println("Restorant'ın Favorilere Eklenme İşlemi Kontrol Ediliyor..");
        ObjectTextControl(addedfavoriteButton,"Favorilerden Çıkar");
        System.out.println("Favorilere Ekleme İşlemi Başarılı..");
    }

    @Step("remove from favorites")
    public void removeFromFavorites(){
        clickFunction(addedfavoriteButton);
        System.out.println("Restorant'ın Favorilerden Çıkarma İşlemi Kontrol Ediliyor..");
        ObjectTextControl(favoriteButton,"Favorilere Ekle");
        System.out.println("Favorilerden Çıkarma İşlemi Başarılı..");
    }

}
