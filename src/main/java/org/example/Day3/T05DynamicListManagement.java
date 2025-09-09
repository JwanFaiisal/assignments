package org.example.Day3;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class T05DynamicListManagement {

    WebDriver driver;
    Faker faker = new Faker();

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
    }

    @AfterEach
    void afterEach() {
        driver.quit();
    }

    @Test
    void testDynamicListManagement() {
        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));

        // 1.
        for (int i = 0; i < 5; i++) {
            String taskName = faker.book().title();
            inputBox.sendKeys(taskName + Keys.ENTER);
        }

        // 2.
        List<WebElement> tasks = driver.findElements(By.cssSelector("ul li"));
        for (int i = 0; i < tasks.size(); i++) {
            if (i % 2 == 0) {
                tasks.get(i).click();
            }
        }

        // 3.
        tasks = driver.findElements(By.cssSelector("ul li"));
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (WebElement task : tasks) {
            if (task.getAttribute("class").contains("completed")) {
                WebElement deleteBtn = task.findElement(By.tagName("span"));
                actions.moveToElement(task).perform();
                deleteBtn.click();

                wait.until(ExpectedConditions.stalenessOf(task));
            }
        }

        // 4.
        List<WebElement> remainingTasks = driver.findElements(By.cssSelector("ul li"));
        for (WebElement task : remainingTasks) {
            assertFalse(task.getAttribute("class").contains("completed"),
                    "Completed task is still present!");
        }

        System.out.println("Remaining tasks:");
        for (WebElement task : remainingTasks) {
            System.out.println("- " + task.getText());
        }

        assertTrue(remainingTasks.size() > 0, "No tasks remaining!");
    }
}
