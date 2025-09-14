package org.example.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task11MultipleiFrames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://demo.guru99.com/test/guru99home/");

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("عدد iframes في الصفحة: " + iframes.size());

        if (iframes.size() > 0) {
            driver.switchTo().frame(0);

            WebElement jmeterLink = driver.findElement(By.linkText("JMeter Made Easy"));
            jmeterLink.click();

            driver.switchTo().defaultContent();
        } else {
            System.out.println("لا يوجد أي iframe في الصفحة.");
        }

        driver.quit();
    }
}
