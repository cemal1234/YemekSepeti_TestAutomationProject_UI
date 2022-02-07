package com.crm.qa.pages.LoginPages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IForgotMyPasswordPage extends TestBase {

    /** I Forgot My Password Page Locators: **/

    @FindBy(id = "emailAddress")
    WebElement emailTextBox;

    @FindBy(xpath = "//a[contains(text(),'Şifremi Unuttum')]")
    WebElement iForgetMyPassTextLink;

    @FindBy(className = "rc-anchor-logo-text")
    WebElement captchaCheckBox;

    @FindBy(xpath = "//button[contains(text(),'GÖNDER')]")
    WebElement sendButton;

    @FindBy(xpath = "//p[@class='bg-success']")
    WebElement passwordResetMessage;

    /** Initializing the Page Objects: **/

    public IForgotMyPasswordPage() {
        PageFactory.initElements(driver, this);
    }

    /** Actions: **/

    @Step("i forgot my password and valid email send page")
    public void iForgotMyPasswordAndValidEmailSendPage() {
        clickFunction(iForgetMyPassTextLink);
        pageTitleControl("Şifremi Unuttum - Yemek Sepeti");
        sendKeysFunction(emailTextBox, prop.getProperty("username"));
        clickFunction(captchaCheckBox);
        clickFunction(sendButton);

    }

    @Step("password reset email message is verified")
    public void passwordResetEmailMessageIsVerified() {

        pageTitleControl("Giriş - Yemek Sepeti");
        ObjectTextControl(passwordResetMessage, "Şifrenizi sıfırlamak için gerekli link e-posta adresinize gönderilmiştir.");
        System.out.println("Sıfırlama Link'inin gönderildiği doğrulandı..");
    }

}
