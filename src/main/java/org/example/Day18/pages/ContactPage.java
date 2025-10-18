package org.example.Day18.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactPage {

    WebDriver driver;
    WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ➕ Add new contact
    public ContactPage addContact(String firstName, String lastName, String birthdate, String email, String phone) {
        driver.findElement(By.id("add-contact")).click();

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("birthdate")).sendKeys(birthdate);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("phone")).sendKeys(phone);

        driver.findElement(By.id("submit")).click();
        return this;
    }

    // ✏️ Edit contact
    public ContactPage editContact(String newFirstName) {
        // نضغط على الصف اللي فيه الاسم "Ali Saleh"
        WebElement contactRow = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[contains(text(),'Ali Saleh')]]"))
        );
        contactRow.click();

        // نضغط زر Edit Contact
        WebElement editButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("edit-contact"))
        );
        editButton.click();

        // نعدل الاسم الأول
        WebElement firstNameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))
        );
        firstNameField.clear();
        firstNameField.sendKeys(newFirstName);

        // نعيد كتابة اللقب (مهم جدًا حتى ما يظهر الخطأ)
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.clear();
        lastNameField.sendKeys("Saleh");

        // نضغط Submit
        driver.findElement(By.id("submit")).click();

        // ننتظر حتى نرجع لصفحة التفاصيل
        wait.until(ExpectedConditions.urlContains("/contactDetails"));
        driver.findElement(By.id("return")).click();

        return this;
    }

    // ❌ Delete contact
    public ContactPage deleteContact() {
        // نضغط على الصف اللي فيه الاسم المعدّل
        WebElement contactRow = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[contains(text(),'Edited Saleh')]]"))
        );
        contactRow.click();

        // نضغط زر الحذف
        WebElement deleteButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("delete"))
        );
        deleteButton.click();

        // نؤكد الحذف في الـ alert
        driver.switchTo().alert().accept();

        return this;
    }
}
