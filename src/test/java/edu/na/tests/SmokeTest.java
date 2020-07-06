package edu.na.tests;

import edu.na.pages.Home;
import edu.na.pages.Portal365;
import edu.na.pojos.Student;
import edu.na.utilities.BasePage;
import edu.na.utilities.BrowserUtils;
import edu.na.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SmokeTest extends BasePage {
    Home home=new Home();
    Portal365 portal365=new Portal365();
    Student student=new Student();
    @Test
    public void mainPage(){
        extentLogger=report.createTest("Home Page Test");
        extentLogger.info("Cheking home page title");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Welcome to North American University | Houston TX");
    }

    @Test
    public void applyNow(){
        home.applyNow.click();
        String oldTab = Driver.getDriver().getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        Driver.getDriver().switchTo().window(newTab.get(0));
        Assert.assertEquals(Driver.getDriver().getTitle(),"Apply North American University");

    }

    @Test
    public void portal365(){
        Driver.getDriver().get("https://login.microsoftonline.com");
        //home.portal365.click();
//        String oldTab = Driver.getDriver().getWindowHandle();
//        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//        newTab.remove(oldTab);
//        Driver.getDriver().switchTo().window(newTab.get(0));

        portal365.email.sendKeys(student.username);
        portal365.next.click();

        portal365.password.sendKeys(student.password);
        //portal365.password.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(3);

        portal365.signIn.click();
        BrowserUtils.waitFor(3);
        portal365.staySignIn_Yes.click();

       // Assert.assertEquals(portal365.allAppsConfirmation.getText(),"All apps");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://www.office.com/?auth=2");
    }

}
