package com.vytrack.tests.vitaliiTS13_70_71;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

public class TS13_70VersionTestNG {
    @Test(description = "Verify access to the Oroinc Documentation page", dataProvider = "credentials")
    public void OroincDocumentationPage(String name, String password) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        Driver.getDriver().get("https://qa2.vytrack.com");
        loginPage.inputLogin.sendKeys(name);
        loginPage.inputPassw.sendKeys(password);
        loginPage.submitBtn.click();

        dashboardPage.questionIcon.click();
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String eachWindow : allWindows) {
            Driver.getDriver().switchTo().window(eachWindow);
            if (!Driver.getDriver().getCurrentUrl().equals("https://doc.oroinc.com")) {
                break;
            }
        }
        for (String eachWindow1 : allWindows) {
            Driver.getDriver().switchTo().window(eachWindow1);
            if (!Driver.getDriver().getCurrentUrl().equals("https://qa2.vytrack.com")) {
                break;
            }
        }
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
