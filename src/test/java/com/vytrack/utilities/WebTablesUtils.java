package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


    public class WebTablesUtils {

        //1. Create a new class called WebTableUtils.
        // 2. Create two methods to verify order


        // Method #1 info:
        // • Name: returnOrderDate ()
//• Return type: String
//• Arg1: WebDriver driver
//• Arg2: String costumerName
        //  This method should accept a costumerName and return the costumer order date
        // as a String.

        public static String returnOrderDate(WebDriver driver, String costumerName){
            String locator = "//td[.='"+costumerName+"']/following-sibling:: td[3]"; // we have to change name to make it dnamic

//String middleName = "Y";
            //String fullName = "Samuil "+middlename+"Jackson;


            WebElement customerDateCell = driver.findElement(By.xpath(locator));

            return customerDateCell.getText();

        }

//public static StringreturnOrderDater2 (WebDriver driver,String customerNmae){
        //return driver.findElement(By.xpath("//td[.='"+customerNmae+"']/following-sibling::[3]")).getText();



        //   Method #2 info:
        //   • Name: orderVerify ()
//• Return type: void
//• Arg1: WebDriver driver
//• Arg2: String customerName
//• Arg3: String expectedOrderDate
        // This method should accept above mentioned arguments and internally assert
        //  expectedOrderDate matching actualOrderDate.

        public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate){
            String locator = "//td[.='"+customerName+"']/following-sibling:: td[3]";
            WebElement customerDateCell = driver.findElement(By.xpath(locator));
            String actualOrderDate = customerDateCell.getText();

            Assert.assertEquals(actualOrderDate,expectedOrderDate);






        }

    }

