package com.vytrack.tests.TS13_78_KiRich;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TS13_78_KiRich {


    @Test(priority = 1, dataProvider = "credentials")
    public void test_frame_TC78 (String name, String password)  {

        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
        Driver.sleep(4);

//        Step 1
        String expectedResult = "Login";
        String actualResult = Driver.getDriver().getTitle();
        Assert.assertEquals(actualResult, expectedResult, "Title is not matching");
        Driver.sleep(4);

//        Step 2
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(name);
        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys(password);
        Driver.getDriver().findElement(By.id("_submit")).click();


        String spanLocator;
        Driver.sleep(4);
        if (name.contains("user")) {
            spanLocator = "(//span[@class='title title-level-1'])[3]";
        } else {
            spanLocator = "(//span[@class='title title-level-1'])[5]";
        }
        WebElement elemActivities = Driver.getDriver().findElement(By.xpath(spanLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(elemActivities).pause(2000).perform();

        WebElement elemCalendarEvent = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']/.."));
        Actions action1 = new Actions(Driver.getDriver());
        actions.moveToElement(elemCalendarEvent).pause(1000).click().perform();


        Driver.sleep(4);
        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        Driver.sleep(4);
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe")));

        WebElement textArea = Driver.getDriver().findElement(By.id("tinymce"));

        String someText = "Some text test";
        textArea.sendKeys(someText);

        Driver.sleep(3);

        actualResult = Driver.getDriver().findElement(By.xpath("//body[@id='tinymce']/p")).getText();
        Assert.assertEquals(actualResult, someText);

        Driver.closeDriver();
    }


    @DataProvider(name="credentials")
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

