package com.crm.qa.pages.LoginPages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncorrectInputTypesPage extends TestBase {

    /** Incorrect Input Types Page Locators: **/

    @FindBy(id = "UserName")
    WebElement usernameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(id = "ys-fastlogin-button")
    WebElement loginButton;

    @FindBy(xpath = "//span[@class='ys-xl inner']//strong")
    WebElement invalidUsernameOrPasswordErrorMessage;

    @FindBy(xpath = "//button[contains(text(),'TAMAM')]")
    WebElement okeyButton;

    @FindBy(xpath = "(//small[@class='help-block'])[1]")
    WebElement userNamepasswordErrorMessage;

    @FindBy(xpath = "(//small[@class='help-block'])[2]")
    WebElement userNamepasswordErrorMessage2;

    /** Initializing the Page Objects: **/

    public IncorrectInputTypesPage() {
        PageFactory.initElements(driver, this);
    }

    /** Actions: **/

    @Step("login with username: {0} and password: {1} step...")
    public void wrongUserNameWithLogin(String un, String pass) {

        sendKeysFunction(usernameTextBox, un);
        sendKeysFunction(passwordTextBox, pass);
        clickFunction(loginButton);

        checkWrongLogin(invalidUsernameOrPasswordErrorMessage);
        clickFunction(okeyButton);

        System.out.println("Hatalı Bilgiler Sebebiyle Giriş Yapılamadı, Tekrar Deneniyor..");
    }

    @Step("login with username: {0} and password: {1} step...")
    public void wrongPasswordWithLogin(String un, String pass) {

        usernamePasswordClear(usernameTextBox, passwordTextBox);

        sendKeysFunction(usernameTextBox, un);
        sendKeysFunction(passwordTextBox, pass);
        clickFunction(loginButton);

        checkWrongLogin(invalidUsernameOrPasswordErrorMessage);
        clickFunction(okeyButton);

        System.out.println("Hatalı Bilgiler Sebebiyle Giriş Yapılamadı, Tekrar Deneniyor..");
    }

    @Step("login with only password: {1} step...")
    public void userNameEmptyLogin(String pass) {

        usernamePasswordClear(usernameTextBox, passwordTextBox);

        sendKeysFunction(passwordTextBox, pass);
        clickFunction(loginButton);

        ObjectTextControl(userNamepasswordErrorMessage,"Lütfen kullanıcı adınızı/e-postanızı giriniz.");
        System.out.println("Eksik Kullanıcı Adı Uyarı Mesajı Görüldü..");

        System.out.println("Eksik Bilgiler Sebebiyle Giriş Yapılamadı, Tekrar Deneniyor..");
    }

    @Step("login with only username: {0} step...")
    public void passwordEmptyLogin(String un) {

        usernamePasswordClear(usernameTextBox, passwordTextBox);

        sendKeysFunction(usernameTextBox, un);
        clickFunction(loginButton);

        ObjectTextControl(userNamepasswordErrorMessage,"Lütfen şifrenizi giriniz.");
        System.out.println("Eksik Şifre Uyarı Mesajı Görüldü..");

        System.out.println("Eksik Bilgiler Sebebiyle Giriş Yapılamadı, Tekrar Deneniyor..");
    }

    @Step("login with wrong username: {0} and password: {1} step...")
    public void wrongUsernameAndPasswordWithLogin(String un, String pass) {

        usernamePasswordClear(usernameTextBox, passwordTextBox);

        sendKeysFunction(usernameTextBox, un);
        sendKeysFunction(passwordTextBox, pass);
        clickFunction(loginButton);

        checkWrongLogin(invalidUsernameOrPasswordErrorMessage);
        clickFunction(okeyButton);

        System.out.println("Hatalı Bilgiler Sebebiyle Giriş Yapılamadı, Tekrar Deneniyor..");
    }

    @Step("login with username and password are empty")
    public void loginWithUsernameAndPasswordAreEmpty() {

        usernamePasswordClear(usernameTextBox, passwordTextBox);
        clickFunction(loginButton);

        ObjectTextControl(userNamepasswordErrorMessage,"Lütfen kullanıcı adınızı/e-postanızı giriniz.");
        System.out.println("Eksik Kullanıcı Adı Uyarı Mesajı Görüldü..");

        ObjectTextControl(userNamepasswordErrorMessage2,"Lütfen şifrenizi giriniz.");
        System.out.println("Eksik Şifre Uyarı Mesajı Görüldü..");

        System.out.println("Eksik Bilgiler Sebebiyle Giriş Yapılamadı, Tekrar Deneniyor..");
    }

}
