package com.vytrack.tests.vitaliiTS13_70_71;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.PinBarHelpPage;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Ts13_71VersionTestNG {


    @Test(priority = 2, description = "Users should see some Messages.", dataProvider = "credentials")
    public void howToUsePinBar(String name, String password) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        PinBarHelpPage pinBarHelpPage = new PinBarHelpPage();

        Driver.getDriver().get("https://qa2.vytrack.com");
        Driver.sleep(2);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.inputLogin));

        loginPage.inputLogin.sendKeys(name);
        loginPage.inputPassw.sendKeys(password);
        loginPage.submitBtn.click();

        wait.until(ExpectedConditions.visibilityOf(dashboardPage.linkLearnEtc));
        dashboardPage.linkLearnEtc.click();

        String actualPinBarMessage = pinBarHelpPage.usePinBarMessage.getText();
        String expectedPinBarMessage = "How To Use Pinbar";
        wait.until(ExpectedConditions.visibilityOf(pinBarHelpPage.usePinBarMessage));
        Assert.assertEquals(actualPinBarMessage, expectedPinBarMessage);

        wait.until(ExpectedConditions.visibilityOf(pinBarHelpPage.usePinIcon));
        String actualUsePinIcon = pinBarHelpPage.usePinIcon.getText();
        String expectedUsePinIcon = "Use pin icon on the right top corner of page to create fast access link in the pinbar.";
        Assert.assertEquals(actualUsePinIcon, expectedUsePinIcon);

        Driver.closeDriver();
    }

    @Test(priority = 1, description = "verify the image source", dataProvider = "credentials")
    public void pictureCheck(String name, String password) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        PinBarHelpPage pinBarHelpPage = new PinBarHelpPage();

        Driver.getDriver().get("https://qa2.vytrack.com");

        loginPage.inputLogin.sendKeys(name);
        loginPage.inputPassw.sendKeys(password);
        loginPage.submitBtn.click();

        dashboardPage.linkLearnEtc.click();
        String actualAttributeValue = pinBarHelpPage.pictureIsDisplayed.getAttribute("src");
        String expectedAttributeValue = "https://qa2.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg";
        Assert.assertEquals(actualAttributeValue, expectedAttributeValue);

        Driver.closeDriver();
    }

    @DataProvider(name = "credentials")
    public Object[][] testData() {
        return new Object[][]{
                {"user184", "UserUser123"},
                {"storemanager251", "UserUser123"},
                {"salesmanager251", "UserUser123"},
        };
    }
}
