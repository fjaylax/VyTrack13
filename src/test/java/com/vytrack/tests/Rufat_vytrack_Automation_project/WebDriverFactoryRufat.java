package com.vytrack.tests.Rufat_vytrack_Automation_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactoryRufat {

    // TASK: NEW METHOD CREATION
    // Method name : getDriver
    // Static method
    // Accepts String arg: browserType
    //   - This arg will determine what type of browser is opened
    //   - if "chrome" passed --> it will open chrome browser
    //   - if "firefox" passed --> it will open firefox browser
    // RETURN TYPE: "WebDriver"


    public static WebDriver getDriver(String browserType){
        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return driver;
        } else if(browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return driver;
        } else if(browserType.equalsIgnoreCase("safari")){
            WebDriverManager.safaridriver().setup();
            WebDriver driver = new SafariDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return driver;
        } else if(browserType.equalsIgnoreCase("EDGE")){
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return driver;
        } else{
            System.out.println("Given browser type doesn't exist/or not currently supported");
            return null;
        }

    }
}
