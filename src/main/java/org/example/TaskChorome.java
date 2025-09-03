package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TaskChorome {
    public static void main(String[] args) throws InterruptedException {
        // 1.
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        // 2.
        driver.manage().window().maximize();

        // 3.
        System.out.println("Maximized Position: " + driver.manage().window().getPosition());
        System.out.println("Maximized Size: " + driver.manage().window().getSize());

        // 4.
        driver.manage().window().minimize();
        Thread.sleep(5000); // waite 5 sec

        // 5.
        driver.manage().window().maximize();
        System.out.println("Re-Maximized Position: " + driver.manage().window().getPosition());
        System.out.println("Re-Maximized Size: " + driver.manage().window().getSize());

        // 6.
        driver.manage().window().fullscreen();
        Thread.sleep(2000);

        // 7.
        driver.quit();
    }
}
