package org.example.Day4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3DragandDropPractice {

    WebDriver driver;
    Actions actions;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver(); // Selenium Manager يتكفل بتشغيل ChromeDriver تلقائياً
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void testDragAndDropInOrder() {

        driver.get("https://claruswaysda.github.io/dragAndDrop.html");

        WebElement piece1 = driver.findElement(By.id("piece1"));
        WebElement slot1 = driver.findElement(By.id("slot1"));
        actions.dragAndDrop(piece1, slot1).perform();

        WebElement piece2 = driver.findElement(By.id("piece2"));
        WebElement slot2 = driver.findElement(By.id("slot2"));
        actions.dragAndDrop(piece2, slot2).perform();

        WebElement piece3 = driver.findElement(By.id("piece3"));
        WebElement slot3 = driver.findElement(By.id("slot3"));
        actions.dragAndDrop(piece3, slot3).perform();

        WebElement celebrateMsg = driver.findElement(By.id("celebrate"));
        assertTrue(celebrateMsg.isDisplayed(), " Puzzle not solved ");

        System.out.println("Puzzle solved ");
    }
}
