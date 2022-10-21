package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class jayUS77_TC9 {
    @Test(priority = 1, dataProvider = "credentials")
    public void test_frame_TC78 (String name, String password)  {
        // 1. Users are on Homepage
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
        Driver.sleep(4);




        // 1.2.User put in Username and password
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(name);
        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys(password);
        Driver.getDriver().findElement(By.id("_submit")).click();

        //layout for users(user184-user190) is different from salesmanagers and storemanagers
        //creating if statement("user" is for Username Login)
        String spanLocator;
        Driver.sleep(4);
        if (name.contains("user")) {
            spanLocator = "(//span[@class='title title-level-1'])[3]";
        } else {
            spanLocator = "(//span[@class='title title-level-1'])[5]";
        }

        // 2.1 locate Activities Button and move cursor on
        WebElement elemActivities = Driver.getDriver().findElement(By.xpath(spanLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(elemActivities).pause(2000).perform();

        // 2.2 locate Calendar Events and click on it
        WebElement elemCalendarEvent = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']/.."));
        Actions action1 = new Actions(Driver.getDriver());
        actions.moveToElement(elemCalendarEvent).pause(1000).click().perform();


       // 3.Click on Button "Create Calendar Event"
        Driver.sleep(4);
        Driver.getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        Driver.sleep(4);

       // com.vytrack.utilities.Driver.getDriver().switchTo().frame(com.vytrack.utilities.Driver.getDriver().findElement(By.xpath("//iframe")));

        // 4.Find and check "Repeat" checkbox
        WebElement repeatCheckBox = Driver.getDriver().findElement(By.xpath("//label[normalize-space()='Repeat']"));
        Driver.sleep(3);
        repeatCheckBox.click();

//       //4.1 Locate "Repeat Every" input
        WebElement checkNumber = Driver.getDriver().findElement(By.xpath("(//input[@value='1'])[2] "));

        Driver.sleep(3000);
        checkNumber.clear();

        Faker faker = new Faker();
        int anyNumber= faker.number().numberBetween(-100,0);
        int anyNUmberPositive =faker.number().numberBetween(100,200);


        int randomOfTwoInts = new Random().nextBoolean() ? anyNumber : anyNUmberPositive;

        checkNumber.sendKeys(String.valueOf(randomOfTwoInts));

        Driver.sleep(3000);


        String verifyLess="The value have not to be less than 1.";
        String verifyMore="The value have not to be more than 99.";

        if(randomOfTwoInts<0){
            System.out.println("verify = " + verifyLess);
            WebElement actualNegative=Driver.getDriver().findElement(By.xpath("//span[text()='The value have not to be less than 1.']"));
            Assert.assertEquals(verifyLess,actualNegative.getText());
        } else if (randomOfTwoInts>99) {
            System.out.println("verifyMore = " + verifyMore);
            WebElement actualPositive=Driver.getDriver().findElement((By.xpath("//span[contains(text(),'The value have not to be more than 99.')]")));
            Assert.assertEquals(verifyMore,actualPositive.getText());

        }
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
              //  {"user189","UserUser123"},
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

