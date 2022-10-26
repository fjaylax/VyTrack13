package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Calendar Events']/..")
    public WebElement calendarEventDropModule;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createCalendarEventBtn;

    @FindBy(xpath = "(//span[normalize-space()='Activities'])[1]")
    public WebElement activitiesDropdownModule;

    @FindBy(xpath = "//i[@class='fa-question-circle']")
    public WebElement questionIcon;

    @FindBy(xpath = "//div[@class='pin-bar-empty']//a")
    public WebElement linkLearnEtc;


}
