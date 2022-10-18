package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    //public static void getDriver (String browserType){
    //if (browserType.equals("Chrome")){
    // WebDriverManager.chromedriver().setup();
    // WebDriver driver= new ChromeDriver();

    //return;
    //  }else if (browserType.equals("Firefox")){
    // WebDriverManager.firefoxdriver().setup();
    // WebDriver driver = new FirefoxDriver();
    // driver.manage()


    public static WebDriver getDriver(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            System.out.println("Given browser does not exist");
            System.out.println("Driver = null");
            return null;
        }
    }

}
