package org.example.Day18.tests;
/*
HW : Requirements
        Application URL: https://thinking-tester-contact-list.herokuapp.com/
        Tasks:
        Create a user account,
        Add a contact,
        Edit the created contact,
        Delete the contact,
        Technical Requirements:
        Use RemoteWebDriver to connect to Selenium Grid
        Implement Fluent Page Object Model design pattern
        Run tests through Grid (not local WebDriver)
        Success Criteria
        User account created successfully
        Contact added to list
        Contact edited with new information
        Contact deleted from list
        Tests run through Selenium Grid
        Fluent POM pattern implemented correctly
        All page transitions work smoothly*/


import org.example.Day18.pages.ContactPage;
import org.example.Day18.pages.SignUpPage;
import org.example.Day18.utilities.driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class ContactTests {

    WebDriver webDriver;

    @BeforeTest
    public void setUp() {
        // 🔹 نحدد القيم هنا مباشرة بدون XML
        String browser = "chrome";
        String gridURL = "http://localhost:4444/wd/hub";

        webDriver = driver.getDriver(browser, gridURL);
    }

    @Test
    public void testContactFlow() {
        // 1️⃣ إنشاء حساب جديد
        new SignUpPage(webDriver)
                .openPage()
                .createAccount("Jwan", "Tester", "jwan" + System.currentTimeMillis() + "@test.com", "Password123");

        // 2️⃣ إضافة جهة اتصال + 3️⃣ تعديلها + 4️⃣ حذفها
        new ContactPage(webDriver)
                .addContact("Ali", "Saleh", "1999-02-01", "ali@test.com", "0501234567")
                .editContact("Edited")
                .deleteContact();
    }

    @AfterTest
    public void tearDown() {
        driver.closeDriver();
    }
}
