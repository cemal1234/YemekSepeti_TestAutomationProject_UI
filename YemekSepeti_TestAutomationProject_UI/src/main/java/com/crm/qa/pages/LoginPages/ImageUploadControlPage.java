package com.crm.qa.pages.LoginPages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ImageUploadControlPage extends TestBase {

    /** Image Upload Control Page Locators: **/

    @FindBy(xpath = "//body//img")
    List<WebElement> imageList;

    /** Initializing the Page Objects: **/

    public ImageUploadControlPage(){
        PageFactory.initElements(driver,this);
    }

    /** Actions: **/

    @Step("image upload control page title validation")
    public void validateImageUploadControlPageTitle(){
        pageTitleControl("Yemek Sepeti - Online Yemek Siparişi ve Paket Servis");
    }

    @Step("loading control of all images")
    public void loadingControlOfAllImages(){

        int imageListSize = imageList.size();

        for (int i = 0; i < imageListSize; i++) {
            elementVisibilityWait(imageList.get(i));
            System.out.println("Image URL: " + imageList.get(i).getAttribute("src"));

            Object result = ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].complete && "+
                            "typeof arguments[0].naturalWidth != \"undefined\" && "+
                            "arguments[0].naturalWidth > 0", imageList.get(i));

            boolean loaded = false;
            if (result instanceof Boolean) {
                loaded = (Boolean) result;
                System.out.println(loaded);
            }
        }
        System.out.println("Total Image Count: " + imageListSize);

    }

}
