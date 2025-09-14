package org.example.Day4;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task10QueryEmojiPicker {

    @Test
    public void emojiPickerTest() {
        // 1.
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // 2.
        driver.manage().window().maximize();

        // 3.
        WebElement iframe = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iframe);

        // 4.
        WebElement animalsTab = driver.findElement(By.xpath("//a[@href='#nature']"));
        animalsTab.click();

        // 5.
        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']//img"));
        for (WebElement emoji : emojis) {
            emoji.click();
        }

        // 6. (parent frame)
        driver.switchTo().defaultContent();

        //cuz i wanna see
        try { Thread.sleep(3000); } catch (InterruptedException e) { }
        driver.quit();
    }
}
