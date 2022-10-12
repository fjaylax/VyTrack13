package com.vytrack.tests;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TS13_70 {
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
    @Test(description = "Verify access to the Oroinc Documentation page", dataProvider = "credentials")
    public void OroincDocumentationPage(String name, String password) {
        WebElement userName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        WebElement userPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
        WebElement questionIcon = driver.findElement(By.xpath("//i[@class='fa-question-circle']"));
        questionIcon.click();
        Set<String> allWindows = driver.getWindowHandles();
        for (String eachWindow : allWindows) {
            driver.switchTo().window(eachWindow);
            if (!driver.getCurrentUrl().equals("https://doc.oroinc.com")) {
                break;
            }
        }
        Set<String> allWindows1 = driver.getWindowHandles();
        for (String eachWindow1 : allWindows) {
            driver.switchTo().window(eachWindow1);
            if (!driver.getCurrentUrl().equals("https://qa2.vytrack.com")) {
                break;
            }
        }
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
    }
}
