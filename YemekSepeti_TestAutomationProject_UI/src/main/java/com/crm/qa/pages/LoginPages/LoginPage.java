package com.crm.qa.pages.LoginPages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    /** Login Page Locators: **/

    @FindBy(id = "UserName")
    WebElement usernameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(id = "ys-fastlogin-button")
    WebElement loginButton;

    By invisibleImageControl = By.id("btnFacebookLogin");

    @FindBy(id = "ysUserName")
    WebElement userNameTextCheck;

    /** Initializing the Page Objects: **/

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    /** Actions: **/

    @Step("login with username: {0} and password: {1} step...")
    public void userNameAndPasswordWithLogin(String un, String pass){

        sendKeysFunction(usernameTextBox,un);
        sendKeysFunction(passwordTextBox,pass);
        clickFunction(loginButton);

        elementInvisibilityWait(invisibleImageControl);

        ObjectTextControl(userNameTextCheck,prop.getProperty("usernameText"));
        System.out.println("Kullanıcı Ad-Soyad Doğrulandı ..");

        cityVerify(driver.getTitle());
    }
}
