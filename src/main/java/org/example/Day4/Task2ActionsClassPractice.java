package org.example.Day4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2ActionsClassPractice {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void testActionsClass() {

        // 1. افتح الصفحة الأولى
        driver.get("https://claruswaysda.github.io/submit-button.html");

        // 2. اضغط Submit
        driver.findElement(By.id("submitButton")).click();

        // 3. انتقل إلى النافذة الجديدة
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // الصفحة الثانية
        WebElement source = driver.findElement(By.id("drag1"));
        WebElement target = driver.findElement(By.id("drop1"));
        actions.dragAndDrop(source, target).perform();
        WebElement dragMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dragSuccessMessage")));
        assertTrue(dragMsg.isDisplayed());

        // Right Click
        WebElement rightClickBtn = driver.findElement(By.id("showSuccessButton"));
        actions.contextClick(rightClickBtn).perform();
        WebElement rightClickMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickSuccessMessage")));
        assertTrue(rightClickMsg.isDisplayed());

        // Double Click
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickButton"));
        actions.doubleClick(doubleClickBtn).perform();
        WebElement doubleClickMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickSuccessMessage")));
        assertTrue(doubleClickMsg.isDisplayed());

        // Hover
        WebElement hoverBtn = driver.findElement(By.id("hoverButton"));
        actions.moveToElement(hoverBtn).perform();
        WebElement hoverMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hoverSuccessMessage")));
        assertTrue(hoverMsg.isDisplayed());
    }
}
