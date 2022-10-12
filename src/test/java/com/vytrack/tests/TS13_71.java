package com.vytrack.tests;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TS13_71 {
    WebDriver driver;

    @BeforeMethod
    public void setUpClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @AfterMethod
    public void tearDownClass() {
        driver.quit();
    }


    @org.testng.annotations.Test(priority = 2, description = "Users should see some Messages.", dataProvider = "credentials")
    public void howToUsePinBar(String name, String password) {


        WebElement userName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        WebElement userPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
        WebElement linkLearnEtc = driver.findElement(By.xpath("//div[@class='pin-bar-empty']//a"));
        linkLearnEtc.click();
        SoftAssert softAssert = new SoftAssert();
        WebElement usePinBarMessage = driver.findElement(By.xpath("//h3[.='How To Use Pinbar']"));
        String actualPinBarMessage = usePinBarMessage.getText();
        String expectedPinBarMessage = "How To Use Pinbar";
        softAssert.assertEquals(actualPinBarMessage, expectedPinBarMessage);
        WebElement usePinIcon = driver.findElement(By.xpath("//div[@class=\"container-fluid\"]//div//p[1]"));////div[@class="container-fluid"]//div//p[1]//text()
        String actualUsePinIcon = usePinIcon.getText();
        String expectedUsePinIcon = "Use pin icon on the right top corner of the page to create fast access link in the pinbar.";
        softAssert.assertEquals(actualUsePinIcon, expectedUsePinIcon);
        softAssert.assertAll();
        WebElement user = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]"));
        user.click();
        WebElement logOut = driver.findElement(By.xpath("//a[@class='no-hash']"));
        logOut.click();
    }

    @org.testng.annotations.Test(priority = 1, description = "verify the image source", dataProvider = "credentials")
    public void pictureCheck(String name, String password) {

        WebElement userName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        WebElement userPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
        WebElement linkLearnEtc = driver.findElement(By.xpath("//div[@class='pin-bar-empty']//a"));
        linkLearnEtc.click();
        WebElement pictureIsDisplayed = driver.findElement(By.xpath("//img[@style='box-shadow: 1px 0px 12px rgba(0,0,0,0.5)']"));
        Assert.assertEquals(pictureIsDisplayed.getAttribute("src"), "https://qa2.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg");
        WebElement user = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]"));
        user.click();
        WebElement logOut = driver.findElement(By.xpath("//a[@class='no-hash']"));
        logOut.click();

    }

    @DataProvider(name = "credentials")
    public Object[][] testData() {
        return new Object[][]{

                {"user184", "UserUser123"},
//                {"user185", "UserUser123"},
//                {"user186", "UserUser123"},
//                {"user187", "UserUser123"},
//                {"user188", "UserUser123"},
//                {"user189","UserUser123"},
//                {"user190","UserUser123"},
                {"storemanager251", "UserUser123"},
//                {"storemanager252", "UserUser123"},
//                {"storemanager253", "UserUser123"},
//                {"storemanager254", "UserUser123"},
                {"salesmanager251", "UserUser123"},
//                {"salesmanager252", "UserUser123"},
//                {"salesmanager253", "UserUser123"},
//                {"salesmanager254", "UserUser123"},
        };
}}
