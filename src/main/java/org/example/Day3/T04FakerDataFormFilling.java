package org.example.Day3;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T04FakerDataFormFilling {

//    WebDriver driver;
//    Faker faker = new Faker();
//    @BeforeEach
//    void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://demoqa.com/text-box"); }
//    @AfterEach
//    void tearDown() {
//        driver.quit(); }
//    @Test
//    void fakerTest() {
//        Map<String, String> fields = Map.of(
//                "userName", faker.name().fullName(),
//                "userEmail", faker.internet().emailAddress(),
//                "currentAddress", faker.address().fullAddress(),
//                "permanentAddress", faker.address().fullAddress())
//                fields.forEach((id, value) -> {
//            driver.findElement(By.id(id)).sendKeys(value);
//            System.out.println(id + " = " + value);
//        }); driver.findElement(By.id("submit")).click();
//        Assertions.assertTrue(driver.findElement(By.id("output")).getText().contains(fields.get("userName")));
//   }
//}

        WebDriver driver;
        String url = "https://demoqa.com/text-box";

        @Test
        void fakerTest() {
            driver.get(url);
            Faker faker = new Faker();
            //        Generate and enter a fake full name
            String fullName = faker.name().fullName();
            System.out.println("fullName = " + fullName);
            driver.findElement(By.id("userName")).sendKeys(fullName);

            //        Generate and enter a fake email address
            String email = faker.internet().emailAddress();
            System.out.println("email = " + email);
            driver.findElement(By.id("userEmail")).sendKeys(email);

            //        Generate and enter a fake current address
            String currentAdress = faker.address().fullAddress();
            System.out.println("currentAdress = " + currentAdress);
            driver.findElement(By.id("currentAddress")).sendKeys(currentAdress);

            //        Generate and enter a fake permanent address
            String permenantAdress = faker.address().fullAddress();
            System.out.println("permenantAdress = " + permenantAdress);
            driver.findElement(By.id("permanentAddress")).sendKeys(permenantAdress);
            //driver.findElement(By.id("permanentAddress")).submit();
            //        Submit the form and verify the output contains the entered data
            //driver.findElement(By.id("submit")).submit();
            driver.findElement(By.id("submit")).click();

            WebElement output = driver.findElement(By.id("output"));

            System.out.println("driver.findElement(By.xpath(\"//p[@class='mb-1'][1]\")).getText() = " + driver.findElement(By.xpath("//p[@class='mb-1'][1]")).getText());
            Assertions.assertTrue(driver.findElement(By.xpath("//p[@class='mb-1'][1]")).getText().contains(fullName));

        }

        @BeforeEach
        void setUp() {
            driver= new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }
    }
