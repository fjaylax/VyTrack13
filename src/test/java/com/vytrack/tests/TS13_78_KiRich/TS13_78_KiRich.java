package com.vytrack.tests.TS13_78_KiRich;

import com.vytrack.pages.CalendarEventPage;
import com.vytrack.pages.CreateCalendarEventPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TS13_78_KiRich {


    public class TS13_78_Kirill_POM {

        @Test(priority = 1, dataProvider = "credentials")
        public void test_frame_TC78_POM(String name, String password) {

            Driver.getDriver().get("https://qa2.vytrack.com/user/login");

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
            wait.until(ExpectedConditions.titleIs("Login"));

            /* LOGIN PAGE */
            LoginPage loginPage = new LoginPage();
            loginPage.inputLogin.sendKeys(name);
            loginPage.inputPassw.sendKeys(password);
            loginPage.submitBtn.click();

            wait.until(ExpectedConditions.titleIs("Dashboard"));


            /* DASHBOARD PAGE */
            DashboardPage dashboardPage = new DashboardPage();
            String spanLocator;

            WebElement elemActivities = dashboardPage.activitiesDropdownModule;
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(elemActivities).pause(2000).perform();

            wait.until(ExpectedConditions.visibilityOf(dashboardPage.calendarEventDropModule));
            dashboardPage.calendarEventDropModule.click();

            wait.until(ExpectedConditions.titleIs("Calendar Events - Activities"));


            /* CALENDAR EVENT PAGE */
            CalendarEventPage calendarEventPage = new CalendarEventPage();

            Driver.sleep(2);
            wait.until(ExpectedConditions
                    .visibilityOf(calendarEventPage.createCalendarEventBtn));
            wait.until(ExpectedConditions
                    .elementToBeClickable(calendarEventPage.createCalendarEventBtn));
            calendarEventPage.createCalendarEventBtn.click();

            wait.until(ExpectedConditions.titleIs("Create Calendar event - Calendar Events - Activities"));


            /* CREATE CALENDAR EVENT PAGE */
            CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();


            Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe")));

            String someText = "Some Text Here";
            createCalendarEventPage.enterTextArea.sendKeys(someText);

            String actualResult = Driver.getDriver().findElement(By.xpath("//body[@id='tinymce']/p")).getText();
            Assert.assertEquals(actualResult, someText);

            Driver.closeDriver();

        }


        @DataProvider(name = "credentials")
        public Object[][] data_users() {
            return new Object[][]{

                    {"user184", "UserUser123"},
                    {"user185", "UserUser123"},
                    {"user186", "UserUser123"},
                    {"user187", "UserUser123"},
                    {"user188", "UserUser123"},
//                {"user189","UserUser123"},
                    {"user190", "UserUser123"},

                    {"storemanager251", "UserUser123"},
                    {"storemanager252", "UserUser123"},
                    {"storemanager253", "UserUser123"},
                    {"storemanager254", "UserUser123"},

                    {"salesmanager251", "UserUser123"},
                    {"salesmanager252", "UserUser123"},
                    {"salesmanager253", "UserUser123"},
                    {"salesmanager254", "UserUser123"}
            };
        }
    }
}

