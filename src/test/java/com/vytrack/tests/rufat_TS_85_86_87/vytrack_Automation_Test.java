package com.vytrack.tests.rufat_TS_85_86_87;

import com.vytrack.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class vytrack_Automation_Test {

    @Test(priority = 1)
    public  void automation_Test_For_Driver()  {
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");


        Map<String, String> users = new HashMap<>(Map.of("user184","UserUser123","user185","UserUser123","user186","UserUser123","user187","UserUser123","user188","UserUser123","user190","UserUser123"));


        for (Map.Entry<String,String> entry: users.entrySet()){
            Login_Logout_Page_utility_vytrack.login(Driver.getDriver(), entry.getKey(), entry.getValue());
//             Login_Logout_Page_utility_vytrack.login(Driver.getDriver(),"driver184","UserUser123");

//            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.titleIs("Dashboard"));
            Driver.sleep(4);

           // Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard","Invalid username or password");
            Driver.verifyTitle(Driver.getDriver(),"Dashboard");
            System.out.println("Current title: " + Driver.getDriver().getTitle());

            WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
            fleetBtn.click();
            WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']"));
            vehicleOdometer.click();

//            wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.titleIs("Vehicle Odometer - Entities - System - Car - Entities - System"));
            Driver.sleep(3);



           // Assert.assertEquals(Driver.getDriver().getTitle(),"Vehicle Odometer - Entities - System - Car - Entities - System","Invalid title");
            Driver.verifyTitle(Driver.getDriver(),"Vehicle Odometer - Entities - System - Car - Entities - System");
            System.out.println("Current title: " + Driver.getDriver().getTitle());


            WebElement page1 = Driver.getDriver().findElement(By.xpath("//input[@type='number']"));
            System.out.println("Default page is " + page1.getAttribute("value"));
            Assert.assertTrue(page1.getAttribute("value").equals("1"),"Page number is not 1");



            WebElement dropdownPage = Driver.getDriver().findElement(By.xpath("(//button[@data-toggle='dropdown'])[1]"));
            System.out.println("Default view per page is " + dropdownPage.getText());
            Assert.assertTrue(dropdownPage.getText().trim().equals("25"),"Drop number is not 25");

            Login_Logout_Page_utility_vytrack.logOut(Driver.getDriver());

//            Thread.sleep(2000);
            Driver.sleep(3);
        }
        Driver.closeDriver();

    }



    @Test(priority = 2)
    public void automation_Test_For_StoreManager() {
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");


        Map<String,String> users = new HashMap<>(Map.of("storemanager251","UserUser123","storemanager252","UserUser123","storemanager253","UserUser123","storemanager254","UserUser123"));

        for(Map.Entry<String,String> eachEntry : users.entrySet()){
            Login_Logout_Page_utility_vytrack.login(Driver.getDriver(),eachEntry.getKey(),eachEntry.getValue());

            // LoginPage.login(driver,"storemanager205","UserUser123");
           // Thread.sleep(4000);
            Driver.sleep(4);

//            Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard","Invalid username or password");
            Driver.verifyTitle(Driver.getDriver(),"Dashboard");
            System.out.println("Current title: " + Driver.getDriver().getTitle());

           // Thread.sleep(4000);
            Driver.sleep(4);

            WebElement fleetBtn1 = Driver.getDriver().findElement(By.xpath("(//a[@class='unclickable'])[2]"));
            fleetBtn1.click();
            WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']"));
            vehicleOdometer.click();

//            Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard","Invalid title");
            Driver.verifyTitle(Driver.getDriver(),"Dashboard");
            System.out.println("Current title: " + Driver.getDriver().getTitle());

            WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
            System.out.println("Error message should be: " + errorMessage.getText());
            Assert.assertTrue(errorMessage.getText().equals("You do not have permission to perform this action."),"Error message doesn't matching");

           Login_Logout_Page_utility_vytrack.logOut(Driver.getDriver());

            //Thread.sleep(2000);
            Driver.sleep(4);
        }
        Driver.closeDriver();
    }
}
