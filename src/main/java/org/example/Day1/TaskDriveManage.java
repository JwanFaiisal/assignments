package org.example.Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class TaskDriveManage {
    public static void main(String[] args) throws InterruptedException {
        // 1.
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");

        // 2.
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        // 3.
        driver.manage().window().setPosition(new Point(100, 200));
        driver.manage().window().setSize(new Dimension(1200, 800));

        // 4.
        System.out.println("New Position: " + driver.manage().window().getPosition());
        System.out.println("New Size: " + driver.manage().window().getSize());

        // 5.
        Thread.sleep(2000);
        driver.quit();
    }
}
