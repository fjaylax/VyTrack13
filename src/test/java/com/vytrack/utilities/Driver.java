package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //creating a private constructor , so we are closing access to the object of this class from outside any classes

    private Driver() {
    }

    //making our driver instance private so is that is not reachable from outside any class. we make it static, because we want to run it before anything else, also we will ude it in static method
    private static WebDriver driver;

    //crate reusable utility method which will return same driver instance when we call it
    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;


            }
        }
        //same driver will return evrytime we call Driver .getDriver method
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null)

            driver.quit(); //this line will kill the sessian value will now be null
        driver=null;
    }

}
