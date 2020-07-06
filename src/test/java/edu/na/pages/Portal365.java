package edu.na.pages;

import edu.na.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Portal365 {
    public Portal365(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement next;

    @FindBy(xpath = "//input[@name='passwd']")
    public WebElement password;

    //@FindBy(linkText = "Sign in")
    @FindBy(id = "idSIButton9")
    public WebElement signIn;

    @FindBy(id = "idSIButton9")
    public WebElement staySignIn_Yes;



}
