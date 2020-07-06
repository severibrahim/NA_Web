package edu.na.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;
    protected static ExtentReports report;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;

    @BeforeMethod
    public void setupMethod() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);

        // driver.manage().window().maximize();

        driver.get(ConfigReader.getKey("url"));


    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = BrowserUtils.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());

        }else if (result.getStatus() == ITestResult.SKIP) {
            extentLogger.skip("Test Case Skipped: " + result.getName());
        }

        //Driver.closeDriver();
    }


    @BeforeTest
    public void setUpTest() {
        report = new ExtentReports();
        String filePath = System.getProperty("user.dir")+"/test-output/report.html";

        htmlReporter = new ExtentHtmlReporter(filePath);

        report.attachReporter(htmlReporter);

        report.setSystemInfo("Environment", "Staging");
        report.setSystemInfo("Browser", ConfigReader.getKey("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        htmlReporter.config().setDocumentTitle("North American University  - WebApplication Reports");
        htmlReporter.config().setReportName("NA TestNG - Automated Test Reports");
        htmlReporter.config().setTheme(Theme.DARK);
    }


    @AfterTest
    public void tearDownTest() {
        report.flush();

    }
}
