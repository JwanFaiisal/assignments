package org.example.Day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T02CheckboxInteraction {

    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/checkboxes";

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    void checkboxesTest() {
        // Locate both checkboxes
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //initial state
        System.out.println("Checkbox 1 selected:" + checkbox1.isSelected());
        System.out.println("Checkbox 2 selected:" + checkbox2.isSelected());

        // if not already selected
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

        // Verify both are selected
        assertTrue(checkbox1.isSelected(), "Checkbox 1 should be selected");
        assertTrue(checkbox2.isSelected(), "Checkbox 2 should be selected");

        // final state
        System.out.println("Checkbox 1 selected:" + checkbox1.isSelected());
        System.out.println("Checkbox 2 selected:" + checkbox2.isSelected());
    }

    @AfterEach
    void afterEach() throws InterruptedException {

        Thread.sleep(5000);    // cuz i want to see the page after selected
        driver.quit();
    }

}
