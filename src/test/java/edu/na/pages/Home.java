package edu.na.pages;

import edu.na.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    public Home(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Apply Now")
    public WebElement applyNow;

    @FindBy(linkText = "365 Portal")
    public WebElement portal365;
}
