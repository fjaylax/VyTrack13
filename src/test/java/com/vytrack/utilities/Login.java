package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    //1. Create a new method for login
//2. Create a method to make Task3 logic re-usable
//3. When method is called, it should simply login

    //This method should have at least 2 overloaded versions.

    // Method #1 info:
    //  • Name: login_crm()
//• Return type: void
//• Arg1: WebDriver


    public static void login_crm(WebDriver driver){

        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUserName.sendKeys("user184");
//4. Enter valid password //UserUser
        WebElement inputUserPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputUserPassword.sendKeys("UserUser123");


//5. Click to Log In button
        WebElement inputLoginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        inputLoginButton.click();


    }






    //  Method #2 info:
    // • Name: login_crm()
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String username
//• Arg3: String password
    public static void login_crm (WebDriver driver, String username, String password){

        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUserName.sendKeys("user184");
//4. Enter valid password //UserUser
        WebElement inputUserPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputUserPassword.sendKeys("UserUser123");


//5. Click to Log In button
        WebElement inputLoginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        inputLoginButton.click();

    }


}
