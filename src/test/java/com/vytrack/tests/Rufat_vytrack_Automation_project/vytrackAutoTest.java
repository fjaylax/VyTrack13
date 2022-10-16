package com.vytrack.tests.Rufat_vytrack_Automation_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class vytrackAutoTest extends TestBase {

    @Test(priority = 1)
    public  void automationTestForDriver() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");


        Map<String, String> users = new HashMap<>(Map.of("user184","UserUser123","user185","UserUser123","user186","UserUser123","user187","UserUser123","user188","UserUser123","user190","UserUser123"));


        for (Map.Entry<String,String> entry: users.entrySet()){
            LoginPage.login(driver, entry.getKey(), entry.getValue());

            // LoginPage.login(driver,"driver184","UserUser123");

//            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.titleIs("Dashboard"));

            Assert.assertEquals(driver.getTitle(),"Dashboard","Invalid username or password");
            System.out.println("Current title: " + driver.getTitle());

            WebElement fleetBtn = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
            fleetBtn.click();
            WebElement vehicleOdometer = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
            vehicleOdometer.click();

//            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.titleIs("Vehicle Odometer - Entities - System - Car - Entities - System"));
            Thread.sleep(2000);


            Assert.assertEquals(driver.getTitle(),"Vehicle Odometer - Entities - System - Car - Entities - System","Invalid title");
            System.out.println("Current title: " + driver.getTitle());


            WebElement page1 = driver.findElement(By.xpath("//input[@type='number']"));
            System.out.println("Default page is " + page1.getAttribute("value"));
            Assert.assertTrue(page1.getAttribute("value").equals("1"),"Page number is not 1");



            WebElement dropdownPage = driver.findElement(By.xpath("(//button[@data-toggle='dropdown'])[1]"));
            System.out.println("Default view per page is " + dropdownPage.getText());
            Assert.assertTrue(dropdownPage.getText().trim().equals("25"),"Drop number is not 25");

            LoginPage.logOut(driver);
            Thread.sleep(2000);
        }

    }



    @Test(priority = 2)
    public void automationTestForStoreManager() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");


        Map<String,String> users = new HashMap<>(Map.of("storemanager251","UserUser123","storemanager252","UserUser123","storemanager253","UserUser123","storemanager254","UserUser123"));

        for(Map.Entry<String,String> eachEntry : users.entrySet()){
            LoginPage.login(driver,eachEntry.getKey(),eachEntry.getValue());

            // LoginPage.login(driver,"storemanager205","UserUser123");

            Assert.assertEquals(driver.getTitle(),"Dashboard","Invalid username or password");
            System.out.println("Current title: " + driver.getTitle());

            Thread.sleep(4000);
            WebElement fleetBtn1 = driver.findElement(By.xpath("(//a[@class='unclickable'])[2]"));
            fleetBtn1.click();
            WebElement vehicleOdometer = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
            vehicleOdometer.click();

            Assert.assertEquals(driver.getTitle(),"Dashboard","Invalid title");
            System.out.println("Current title: " + driver.getTitle());

            WebElement errorMessage = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
            System.out.println("Error message should be: " + errorMessage.getText());
            Assert.assertTrue(errorMessage.getText().equals("You do not have permission to perform this action."),"Error message doesn't matching");

            LoginPage.logOut(driver);
            Thread.sleep(2000);
        }

    }
}
