package com.vytrack.tests.NadiaTS13_74;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Nadia_TS13_74 {
    @Test(priority = 1,dataProvider = "credentials")
    public void test_frame_TC74(String name,String password) {

        Driver.getDriver().get("https://qa2.vytrack.com/user/login");

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        userName.sendKeys(name);
        WebElement userPassword = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        userPassword.sendKeys(password);
        WebElement login = Driver.getDriver().findElement(By.xpath("//button[@id='_submit']"));
        login.click();

        String spanLocator;
        Driver.sleep(5);
        if (name.contains("user")) {
            spanLocator = "(//span[@class='title title-level-1'])[1]";
        } else {
            spanLocator = "(//span[@class='title title-level-1'])[2]";
        }

        WebElement FleetBtn = Driver.getDriver().findElement(By.xpath(spanLocator));
        Actions actions1 = new Actions(Driver.getDriver());
        actions1.moveToElement(FleetBtn).perform();

        WebElement VehicleBtn = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']/.."));
        Actions actions2 = new Actions(Driver.getDriver());
        actions2.moveToElement(VehicleBtn).click().perform();
       Driver.sleep(5);

        WebElement treeDots = Driver.getDriver().findElement(By.xpath("(//div[@class='dropdown']/a)[1]"));
        Actions actions3 = new Actions(Driver.getDriver());
        actions3.moveToElement(treeDots).pause(4000).perform();

       Driver.sleep(8);
        WebElement ViewBtn = Driver.getDriver().findElement(By.xpath(" //li[@class='launcher-item']/a[1]"));
        Actions actions4 = new Actions(Driver.getDriver());
        actions4.moveToElement(ViewBtn).perform();
        System.out.println("ViewBtn.getAttribute(\" title\") = " + ViewBtn.getAttribute("title"));
        String actualView = ViewBtn.getAttribute("title");
        String expectedView = "View";
        Assert.assertEquals(actualView, expectedView);

        WebElement EditBtn = Driver.getDriver().findElement(By.xpath("(//li[@class='launcher-item']/a)[2]"));
        Actions actions5 = new Actions(Driver.getDriver());
        actions5.moveToElement(EditBtn).perform();
        System.out.println("EditBtn.getAttribute(\"title\") = " + EditBtn.getAttribute("title"));
        String actualEdit = EditBtn.getAttribute("title");
        String expectedEdit = "Edit";
        Assert.assertEquals(actualEdit, expectedEdit);

        WebElement DeleteBtn = Driver.getDriver().findElement(By.xpath("(//li[@class='launcher-item']/a)[3]"));
        Actions actions6 = new Actions(Driver.getDriver());
        actions6.moveToElement(DeleteBtn).perform();
        System.out.println("DeleteBtn.getAttribute(\"title\") = " + DeleteBtn.getAttribute("title"));
        String actualDelete = DeleteBtn.getAttribute("title");
        String expectedDelete = "Delete";
        Assert.assertEquals(actualDelete, expectedDelete);

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



