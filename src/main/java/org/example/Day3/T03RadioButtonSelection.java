package org.example.Day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T03RadioButtonSelection {

    WebDriver driver;
    String url = "http://test.rubywatir.com/radios.php";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    void radioButtonTest() throws InterruptedException {
        // Locate all radio buttons
        List<WebElement> radios = driver.findElements(By.xpath("//p/input"));

        for (WebElement radio : radios) {
            String value = radio.getAttribute("value"); // Get radio name

            // Print whether enabled or disabled
            System.out.println("Option '" + value + "' enabled? " + radio.isEnabled());

            if (!radio.isEnabled()) {
                System.out.println("Skipping '" + value + "' because it is disabled.");
                continue;
            }

            // Click and verify selection
            radio.click();
            if (radio.isSelected()) {
                System.out.println("'" + value + "' button selected!!");
            } else {
                System.out.println("'" + value + "' button selection failed ");
            }

            // Optional: short pause to see the click
            Thread.sleep(1000);
        }
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        // Leave browser open 5 seconds to check final state
        Thread.sleep(5000);
        driver.quit();
    }
}
