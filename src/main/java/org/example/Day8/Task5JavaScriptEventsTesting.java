package org.example.Day8;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Task5JavaScriptEventsTesting {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Robot robot = new Robot();

        // 1. OnClick
        driver.findElement(By.id("onclick")).click();

        // 2. OnDoubleClick
        WebElement dbl = driver.findElement(By.id("ondoubleclick"));
        js.executeScript("arguments[0].scrollIntoView(true);", dbl);
        dbl.click();
        dbl.click();

        // 3. OnContextMenu (right click)
        WebElement context = driver.findElement(By.id("oncontextmenu"));
        js.executeScript("arguments[0].scrollIntoView(true);", context);
        robot.mouseMove(context.getLocation().getX()+5, context.getLocation().getY()+5);
        robot.mousePress(java.awt.event.InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(java.awt.event.InputEvent.BUTTON3_DOWN_MASK);

        // 4. OnMouseOver
        WebElement over = driver.findElement(By.id("onmouseover"));
        js.executeScript("arguments[0].scrollIntoView(true);", over);
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles:true}));", over);

        // 5. OnMouseLeave
        WebElement leave = driver.findElement(By.id("onmouseleave"));
        js.executeScript("arguments[0].scrollIntoView(true);", leave);
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseleave', {bubbles:true}));", leave);

        // 6. OnFocus و OnBlur
        WebElement focus = driver.findElement(By.id("onfocus"));
        focus.click();       // OnFocus
        driver.findElement(By.id("onclick")).click(); // OnBlur

        // 7. OnKeyDown, OnKeyUp, OnKeyPress
        WebElement keyDown = driver.findElement(By.id("onkeydown"));
        keyDown.click();
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);

        WebElement keyUp = driver.findElement(By.id("onkeyup"));
        keyUp.click();
        robot.keyPress(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_B);

        WebElement keyPress = driver.findElement(By.id("onkeypress"));
        keyPress.click();
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);

        System.out.println("✅ All buttons triggered successfully!");
        Thread.sleep(3000);
        driver.quit();
    }
}
