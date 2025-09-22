package org.example.Day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Task5SoftAssertionsPractice {

    private WebDriver driver;
    private final String url = "https://claruswaysda.github.io/signIn.html";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test(description = "Negative login test with soft assertions")
    public void negativeLoginTest() {
        driver.get(url);

        // 1. إدخال بيانات خاطئة
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");

        // 2. الضغط على زر Sign In
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // SoftAssert object
        SoftAssert softAssert = new SoftAssert();

        try {
            // 3. انتظار ظهور الـ Alert
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            // 4. التحقق أن الـ Alert موجود
            softAssert.assertNotNull(alert, "❌ Expected an alert, but none appeared.");

            // 5. التحقق من نص الرسالة
            String actualAlertText = alert.getText();
            String expectedAlertText = "Incorrect username or password";
            softAssert.assertEquals(actualAlertText, expectedAlertText,
                    "❌ Alert text is NOT as expected!");

            // إغلاق الـ Alert
            alert.accept();

        } catch (Exception e) {
            // لو ما ظهر Alert → نعتبرها فشل بالـ soft assert
            softAssert.fail("❌ No alert appeared after submitting wrong credentials. Exception: " + e.getMessage());
        }

        // لازم دايمًا نستدعي assertAll عشان تطبع نتيجة كل SoftAssert
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
