package org.example.Day15;


/*
Target: https://thinking-tester-contact-list.herokuapp.com/
Test Scenario:
Navigate to the application,
Create a new user account,
Login with the created user,
Add 5 different contacts,
Assert that all contacts are properly added and displayed,
Page Objects Needed:
LoginPage (registration and login elements),
ContactListPage (contact management elements),
AddContactPage (contact form elements),
Assertions:
Verify successful user registration,
Verify successful login,
Verify each contact is added correctly,
Verify total contact count equals 5,
Reporting Requirements:
Use ExtentReports,
Create TestBaseReport base class,
Add .info() logs for each major step,
Use .pass() for successful assertions,
Use .fail() for failed assertions with screenshots,
Add system information (Browser, Environment, Tester),
Generate report with timestamp in filename,
*/

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

        import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBaseReport {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport(){
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport_" + timestamp + ".html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Gg");
    }

    @BeforeClass
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDownDriver(){
        if(driver != null) driver.quit();
    }

    @AfterSuite
    public void flushReport(){
        if(extent != null) extent.flush();
    }
}