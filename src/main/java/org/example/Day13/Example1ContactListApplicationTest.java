package org.example.Day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.example.Day13.Pages.*;
import org.example.Day13.Utilities.Driver;

import java.time.Duration;

public class Example1ContactListApplicationTest {

    @Test
    public void contactListTest() {
        WebDriver driver = Driver.getDriver();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");

        LoginPage loginPage = new LoginPage();
        SignUpPage signUpPage = new SignUpPage();
        ContactListPage contactListPage = new ContactListPage();
        AddContactPage addContactPage = new AddContactPage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1️⃣ تسجيل مستخدم جديد
        loginPage.signUpButton.click();
        String uniqueEmail = "ali" + System.currentTimeMillis() + "@test.com";
        signUpPage.signUp("Ali", "Test", uniqueEmail, "12345678");

        // 2️⃣ بيانات الـ Contacts
        String[][] contactsData = {
                {"Contact1", "Last1"},
                {"Contact2", "Last2"},
                {"Contact3", "Last3"},
                {"Contact4", "Last4"},
                {"Contact5", "Last5"}
        };

        By addContactBtnLocator = By.id("add-contact");
        By firstNameLocator = By.id("firstName");
        By lastNameLocator = By.id("lastName");
        By emailLocator = By.id("email");
        By submitBtnLocator = By.id("submit");
        By contactRowsLocator = By.xpath("//tr[@class='contactTableBodyRow']");

        // 3️⃣ إضافة 5 Contacts مع الانتظار لكل صف جديد
        for (int i = 0; i < contactsData.length; i++) {

            // اضغط Add Contact
            wait.until(ExpectedConditions.elementToBeClickable(addContactBtnLocator)).click();

            // عبي البيانات
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameLocator))
                    .sendKeys(contactsData[i][0]);
            driver.findElement(lastNameLocator).sendKeys(contactsData[i][1]);
            driver.findElement(emailLocator).sendKeys("contact" + i + "@test.com");

            // Submit
            driver.findElement(submitBtnLocator).click();

            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(contactRowsLocator, i));
        }

        Assert.assertEquals(driver.findElements(contactRowsLocator).size(),
                contactsData.length, "Number of contacts mismatch!");
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    public static class Example2BankingApplicationTest {
    }
}
