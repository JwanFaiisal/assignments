package org.example.Day4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Task6DropdownHandling {

    WebDriver driver;
    Actions actions;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testDropdowns() throws InterruptedException {
        driver.get("https://claruswaysda.github.io/Dropdowns.html");

        // 1. Traditional Dropdown select 'Ford'
        Select traditional = new Select(driver.findElement(By.id("carSelect")));
        traditional.selectByVisibleText("Ford");

        // 2. Multi-Select Dropdown select 'Mercedes'
        Select multi = new Select(driver.findElement(By.id("multiCarSelect")));
        multi.selectByVisibleText("Mercedes");

        // 3. Custom Dropdown (Bootstrap-like) select 'BMW'
        WebElement customDropdown = driver.findElement(By.id("customDropdown"));
        customDropdown.click();
        WebElement customOption = driver.findElement(By.xpath("//div[@id='customList']/div[text()='BMW']"));
        customOption.click();

        // 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
        WebElement staticInput = driver.findElement(By.id("staticInput"));
        staticInput.sendKeys("Tesla");
        WebElement staticOption = driver.findElement(By.xpath("//div[@id='staticSuggestions']/div[text()='Tesla Model 3']"));
        staticOption.click();

        // 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
        WebElement dynamicInput = driver.findElement(By.id("dynamicInput"));
        dynamicInput.sendKeys("Toyota");
        WebElement dynamicOption = driver.findElement(By.xpath("//div[@id='dynamicSuggestions']/div[text()='Toyota']"));
        dynamicOption.click();

        Thread.sleep(1000); //  wait to see the selection
    }
}
