package org.example.Day12;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Task3NegativeTestingwithDataProvider {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://claruswaysda.github.io/signIn.html");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    // DataProvider = جميع السيناريوهات السلبية
    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"", ""},                 // الاثنين فاضيين
                {"wronguser", ""},        // يوزر غلط وباسورد فاضي
                {"", "wrongpass"},        // يوزر فاضي وباسورد غلط
                {"wronguser", "wrongpass"}// الاثنين غلط
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void negativeLoginTest(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        try {
            // التعامل مع الـ Alert
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertTrue(alertText.contains("Incorrect"),
                    "Expected 'Incorrect username or password' alert but got: " + alertText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            // fallback: لو ما طلع Alert نتأكد إننا لسه في نفس الصفحة
            Assert.assertTrue(driver.getCurrentUrl().contains("signIn.html"),
                    "Expected to stay on signIn page with invalid credentials.");
        }
    }
}
