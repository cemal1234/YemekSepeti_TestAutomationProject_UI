package com.crm.qa.pages.LoginPages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WrongAndSuccessfulLoginPage extends TestBase {

    /** Wrong And Successful Login Page PageLocators: **/

    @FindBy(id = "UserName")
    WebElement usernameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(id = "ys-fastlogin-button")
    WebElement loginButton;

    By invisibleImageControl = By.id("btnFacebookLogin");

    @FindBy(id = "ysUserName")
    WebElement userNameTextCheck;

    @FindBy(xpath = "//span[@class='ys-xl inner']//strong")
    WebElement invalidUsernameErrorMessage;

    @FindBy(xpath = "//button[contains(text(),'TAMAM')]")
    WebElement okeyButton;

    /** Initializing the Page Objects: **/

    public WrongAndSuccessfulLoginPage(){
        PageFactory.initElements(driver,this);
    }

    /** Actions: **/

    @Step("login with username: {0} and password: {1} step...")
    public void wrongUsernameThenSuccessfulLogin(String un, String pass){

        sendKeysFunction(usernameTextBox,un);
        sendKeysFunction(passwordTextBox,pass);
        clickFunction(loginButton);

        checkWrongLogin(invalidUsernameErrorMessage);
        clickFunction(okeyButton);

        System.out.println("Doğru Bilgiler ile Tekrar Giriş Yapılıyor.. ");

    }

    @Step("Retry login with username: {0} and password: {1} step...")
    public void correctUsernameWithLogin(String un, String pass){

        usernameTextBox.clear();
        passwordTextBox.clear();

        sendKeysFunction(usernameTextBox,un);
        sendKeysFunction(passwordTextBox,pass);
        clickFunction(loginButton);

        elementInvisibilityWait(invisibleImageControl);

        ObjectTextControl(userNameTextCheck,prop.getProperty("usernameText"));
        System.out.println("Kullanıcı Ad-Soyad Doğrulandı ..");

        cityVerify(driver.getTitle());
    }
}
