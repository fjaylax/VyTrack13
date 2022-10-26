package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCalendarEventPage {

    public CreateCalendarEventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div[@id='mceu_150']/iframe")
    public WebElement textFrame;

    @FindBy (id = "tinymce")
    public WebElement enterTextArea;
}

