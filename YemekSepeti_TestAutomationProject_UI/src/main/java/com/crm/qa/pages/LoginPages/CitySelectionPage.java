package com.crm.qa.pages.LoginPages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CitySelectionPage extends TestBase {

    /** City Selection Page Locators: **/

    @FindBy(xpath = "//div[@class='innerHeader']/h1")
    WebElement loginPageTextControl;

    @FindBy(xpath = "//div[@class='cityPlatesContainer']//div[@class='cityContainer']")
    List<WebElement> randomCityList;

    By invisibleImageControl = By.className("cityPlatesContainer");

    /** Initializing the Page Objects: **/

    public CitySelectionPage(){
        PageFactory.initElements(driver,this);
    }

    /** Actions: **/

    @Step("city selection page title validation")
    public void validateCitySelectionPageTitle(){
        pageTitleControl("Yemek Sepeti - Online Yemek Siparişi ve Paket Servis");
    }

    @Step("city selection page inner header validation")
    public void validateCitySelectionPageInnerHeader(){
        ObjectTextControl(loginPageTextControl,"Yemeksepeti'yle yemeğin sadece birkaç tık uzaklıkta! Şehrinizi seçip sipariş verin.");
    }

    @Step("random city selection")
    public void randomCitySelectionAndClick() throws InterruptedException {
        elementsVisibilityWait(randomCityList);
        randomCitySelect(randomCityList);
    }

    @Step("login page title validation")
    public void validateLoginPageTitle(){
        elementInvisibilityWait(invisibleImageControl);

        cityVerify(driver.getTitle());
    }

}
