package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    //In this class only general utility methods that are not related to some specific page.





        public static void sleep(int second){
            second*=1000;
            try{
                Thread.sleep(second);
            }catch(InterruptedException e){

            }



        }

        //this method accepts 3 arg
        //arg1: webdriver
        //arg2:expected InUrl : for verify if the url contains given String
        //if conditions is true it will break the loop
        //arr3 expectedTitle will be compared to actualTitle
        public static void switchWindownAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle) {
            Set<String> allWindowshandles = driver.getWindowHandles();
            for (String each : allWindowshandles) {
                driver.switchTo().window(each);
                System.out.println("Current URL: " + driver.getCurrentUrl());

                if(driver.getCurrentUrl().contains("etsy")){
                    break;
                }

            }
            //5 Assert:Title contains "ExpectedTitle"
            //lines to be pasted
            //5 Assert:Title contains "Etsy"
            //lines to be pasted
            String actualTitle = driver.getTitle();

            Assert.assertTrue(actualTitle.contains(expectedInTitle));
        }

        //this method accepts a String "expectedTitle " and assers if it is true
        public static void verifyTitle(WebDriver driver,String expectedTitle){
            Assert.assertEquals(driver.getTitle(),expectedTitle);
        }

    }


