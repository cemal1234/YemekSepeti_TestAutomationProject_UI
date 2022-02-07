package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;
    public static Actions actions;

    static String projectPath = System.getProperty("user.dir");

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(projectPath + "/src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
            File pathBinary = new File("C:\\Program Files\\Firefox\\firefox.exe"); // Firefox dizini verilmeli !!!
            FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
            DesiredCapabilities desired = DesiredCapabilities.firefox();
            FirefoxOptions options = new FirefoxOptions();
            desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));

            driver = new FirefoxDriver(options);
        }

        wait = new WebDriverWait(driver,30);
        actions = new Actions(driver);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }

    /** Functions **/

    public void clickFunction(WebElement clickElement){
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));

        clickElement.click();
    }

    public void sendKeysFunction(WebElement sendKeysElement, String value){
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));

        sendKeysElement.sendKeys(value);
    }

    public void checkWrongLogin(WebElement messageVisible) {
        Assert.assertTrue(messageVisible.isDisplayed(),"Hatalı Giriş Mesajı Gösterilmedi !");
        System.out.println("Hatalı Giriş Mesajı : " + messageVisible.getText()+"\n");

    }

    public void pageTitleControl(String expected){
        Assert.assertEquals(driver.getTitle(),expected);
        System.out.println("Location : " + driver.getTitle() + "\n");

    }

    public void cityVerify(String driverTitle){
        String[] textList = driverTitle.split(" ");
        String titleEmptyText = textList[0];
        Assert.assertEquals(driver.getTitle(),titleEmptyText+" Online Yemek Siparişi, Paket Servis - Yemek Sepeti");
        System.out.println("Location : " + titleEmptyText+" Online Yemek Siparişi, Paket Servis - Yemek Sepeti" + "\n");

    }

    public void usernamePasswordClear(WebElement username, WebElement password){
        username.clear();
        password.clear();
    }

    public void ObjectTextControl(WebElement actual, String expected){
        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getText(),expected);
        System.out.println("Object Text : " + actual.getText());

    }

    public void elementVisibilityWait(WebElement elementVisible){
        wait.until(ExpectedConditions.visibilityOf(elementVisible));
    }

    public void elementInvisibilityWait(By Locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Locator));
    }

    public void elementsVisibilityWait(List<WebElement> elementList){
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public void randomCitySelect(List<WebElement> randomCity) throws InterruptedException {
        System.out.println("Random Şehire Tıklanıyor.. "+"\n");

        Random randomC = new Random();
        int randomCityS = randomC.nextInt(randomCity.size());
        Thread.sleep(5000);
        randomCity.get(randomCityS).click();

    }

    public void randomRestaurantSelect(List<WebElement> randomRestaurant) throws InterruptedException {
        System.out.println("Random Restorant aranıyor.."+"\n");

        Random randomR = new Random();
        int randomRest = randomR.nextInt(randomRestaurant.size());
        Thread.sleep(5000);
        randomRestaurant.get(randomRest).click();

    }

}
