package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "prependedInput")
    public WebElement inputLogin;

    @FindBy (id = "prependedInput2")
    public WebElement inputPassw;

    @FindBy (id = "_submit")
    public WebElement submitBtn;
}
