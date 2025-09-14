package org.example.Day4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4DrawingPractice {

    WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void drawTriangleAndReset() throws InterruptedException {
        // 1.
        driver.get("https://claruswaysda.github.io/Draw.html");

        // 2.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("""
            const canvas = document.getElementById('myCanvas');
            const ctx = canvas.getContext('2d');
            ctx.lineWidth = 2;
            ctx.strokeStyle = '#000';
            ctx.beginPath();
            ctx.moveTo(100, 100); // النقطة الأولى
            ctx.lineTo(200, 100); // النقطة الثانية
            ctx.lineTo(150, 50);  // النقطة الثالثة
            ctx.closePath();
            ctx.stroke();
        """);

        // 3.
        Thread.sleep(3000);

        // 4.
        driver.findElement(By.id("resetButton")).click();
        Thread.sleep(1000);
    }
}
