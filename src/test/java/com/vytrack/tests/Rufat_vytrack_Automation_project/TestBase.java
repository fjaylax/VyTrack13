package com.vytrack.tests.Rufat_vytrack_Automation_project;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactoryRufat.getDriver("chrome");

        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        // driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
