package com.crm.qa.pages.LoginPages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithFacebookLoginPage extends TestBase {

    /** With Facebook Login Page Locators: **/

    @FindBy(id = "btnFacebookLogin")
    WebElement withfacebookLoginButton;

    @FindBy(xpath = "//input[@id='email']")
    WebElement facebookUserNameTextBox;

    @FindBy(id = "pass")
    WebElement facebookPasswordTextBox;

    @FindBy(name = "login")
    WebElement facebookLoginButton;

    @FindBy(xpath = "//span[contains(text(),' Olarak Devam Et')]")
    WebElement facebookContinueAsButton;

    @FindBy(xpath = "//div[@class='container']//h1")
    WebElement allWelcomeMessageText;

    By invisiblefacebookContinueAsButton = By.xpath("//span[contains(text(),' Olarak Devam Et')]");

    /** Initializing the Page Objects: **/

    public WithFacebookLoginPage(){
        PageFactory.initElements(driver,this);
    }

    /** Actions: **/

    @Step("login with username: {0} and password: {1} step...")
    public void facebookLoginPage(String un, String pass) throws InterruptedException {

        clickFunction(withfacebookLoginButton);
        System.out.println("Giriş için Facebook sayfasına gidiliyor..");

        driver.getWindowHandles();
        for(String winHandle : driver.getWindowHandles()){

            driver.switchTo().window(winHandle);
        }

        sendKeysFunction(facebookUserNameTextBox,un);
        sendKeysFunction(facebookPasswordTextBox,pass);
        clickFunction(facebookLoginButton);

        clickFunction(facebookContinueAsButton);
        elementInvisibilityWait(invisiblefacebookContinueAsButton);

        String[] textList = allWelcomeMessageText.getText().split(" ");
        String titleEmptyText = textList[1];
        ObjectTextControl(allWelcomeMessageText," Merhaba "+titleEmptyText);
        System.out.println("Facebook ile Login İşlemi Tamamlandı..");

    }
}
