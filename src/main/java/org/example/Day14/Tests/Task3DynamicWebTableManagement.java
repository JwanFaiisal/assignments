package org.example.Day14.Tests;

import org.example.Day14.Pages.FluentWebTablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Task3DynamicWebTableManagement {
    WebDriver driver;
    FluentWebTablePage tablePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        tablePage = new FluentWebTablePage(driver);
        tablePage.openPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "records")
    public Object[][] getData() {
        return new Object[][]{
                {"Ali", "28", "USA"},
                {"Sara", "25", "UK"},
                {"Omar", "30", "Canada"},
                {"Lina", "27", "Australia"},
                {"Mona", "32", "Germany"}
        };
    }

    @Test(dataProvider = "records")
    public void addRecordTest(String name, String age, String country) {
        tablePage.addRecord(name, age, country)
                .verifyRecordExists(name, age, country);
    }

    @Test(dependsOnMethods = "addRecordTest")
    public void deleteFirstRecordTest() {
        tablePage.deleteRecordByName("Ali");
        // تحقق أن السجل حذف
        try {
            tablePage.verifyRecordExists("Ali", "28", "USA");
            throw new AssertionError("Record was not deleted!");
        } catch (Exception e) {
            // إذا لم يتم إيجاده فهذا جيد
        }
    }
}
