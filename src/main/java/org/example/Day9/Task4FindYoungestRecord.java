package org.example.Day9;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task4FindYoungestRecord {

    @Test
    public void findYoungestRecord() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        Faker faker = new Faker();

        // أضف 10 سجلات
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("nameInput")).sendKeys(faker.name().firstName());
            driver.findElement(By.id("ageInput")).sendKeys(String.valueOf(faker.number().numberBetween(18, 80)));
            driver.findElement(By.id("countrySelect")).sendKeys("USA");
            driver.findElement(By.xpath("//button[text()='Add Record']")).click();

            // مسح الحقول عشان يقدر يضيف مرة ثانية
            driver.findElement(By.id("nameInput")).clear();
            driver.findElement(By.id("ageInput")).clear();
        }

        // استخراج كل الصفوف من tbody
        List<WebElement> rows = driver.findElements(By.xpath("//tbody[@id='tableBody']/tr"));

        String youngestName = "";
        int youngestAge = Integer.MAX_VALUE;

        // المرور على كل الصفوف
        for (WebElement row : rows) {
            String name = row.findElement(By.xpath("./td[1]")).getText(); // الاسم
            int age = Integer.parseInt(row.findElement(By.xpath("./td[2]")).getText()); // العمر
            String country = row.findElement(By.xpath("./td[3]")).getText(); // الدولة

            if (age < youngestAge) {
                youngestAge = age;
                youngestName = name;
            }
        }

        System.out.println("The youngest record is: " + youngestName + " with age " + youngestAge);

        driver.quit();
    }
}
