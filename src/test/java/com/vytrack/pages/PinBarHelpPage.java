package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinBarHelpPage {
    public PinBarHelpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h3[.='How To Use Pinbar']")
    public WebElement usePinBarMessage;

    @FindBy(xpath = "//div[@class=\"container-fluid\"]//div//p[1]")
    public WebElement usePinIcon;

    @FindBy(xpath = "//img[@style='box-shadow: 1px 0px 12px rgba(0,0,0,0.5)']")
    public WebElement pictureIsDisplayed;

}
