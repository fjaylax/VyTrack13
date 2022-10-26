package com.vytrack.tests.vitaliiTS13_70_71;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TS13_71 {

        @BeforeMethod ()
    public void login() {
       Driver.getDriver().get("https://qa2.vytrack.com");

    }

    @AfterMethod
    public void logout() {
        Driver.closeDriver();
    }

    @Test(priority = 2, description = "Users should see some Messages.", dataProvider = "credentials")
    public void howToUsePinBar(String name, String password) {

//        Driver.getDriver().get("https://qa2.vytrack.com/user/login");

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        WebElement userPassword = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@id='_submit']"));
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


        WebElement linkLearnEtc = Driver.getDriver().findElement(By.xpath("//div[@class='pin-bar-empty']//a"));
        wait.until(ExpectedConditions.visibilityOf(linkLearnEtc));
        linkLearnEtc.click();

        WebElement usePinBarMessage = Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));
        wait.until(ExpectedConditions.visibilityOf(usePinBarMessage));
        String actualPinBarMessage = usePinBarMessage.getText();
        String expectedPinBarMessage = "How To Use Pinbar";
        Assert.assertEquals(actualPinBarMessage, expectedPinBarMessage);
        WebElement usePinIcon = Driver.getDriver().findElement(By.xpath("//div[@class=\"container-fluid\"]//div//p[1]"));
        wait.until(ExpectedConditions.visibilityOf(usePinIcon));
        String actualUsePinIcon = usePinIcon.getText();
        String expectedUsePinIcon = "Use pin icon on the right top corner of the page to create fast access link in the pinbar.";
        Assert.assertEquals(actualUsePinIcon, expectedUsePinIcon);

//        WebElement user2 = Driver.getDriver().findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]"));
//        user2.click();
//        WebElement logOut2 = Driver.getDriver().findElement(By.xpath("//a[@class='no-hash']"));
//        logOut2.click();
    }

    @Test(priority = 1, description = "verify the image source", dataProvider = "credentials")
    public void pictureCheck(String name, String password) {
        Driver.getDriver().get("https://qa2.vytrack.com");
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        WebElement userPassword = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@id='_submit']"));
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
        WebElement linkLearnEtc = Driver.getDriver().findElement(By.xpath("//div[@class='pin-bar-empty']//a"));
        linkLearnEtc.click();
        WebElement pictureIsDisplayed = Driver.getDriver().findElement(By.xpath("//img[@style='box-shadow: 1px 0px 12px rgba(0,0,0,0.5)']"));
        Assert.assertEquals(pictureIsDisplayed.getAttribute("src"), "https://qa2.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg");
//        WebElement user = Driver.getDriver().findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]"));
//        user.click();
//        WebElement logOut = Driver.getDriver().findElement(By.xpath("//a[@class='no-hash']"));
//        logOut.click();

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
