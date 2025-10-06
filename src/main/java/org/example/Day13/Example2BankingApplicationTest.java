package org.example.Day13;

import com.github.javafaker.Faker;
import org.example.Day13.Pages.*;
        import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Example2BankingApplicationTest {
    WebDriver driver;
    ManagerLoginPage managerLoginPage;
    CustomerManagementPage customerManagementPage;
    AccountManagementPage accountManagementPage;
    Faker faker;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        managerLoginPage = new ManagerLoginPage(driver);
        customerManagementPage = new CustomerManagementPage(driver);
        accountManagementPage = new AccountManagementPage(driver);
        faker = new Faker();
    }

    @Test
    public void testAddCustomerAndOpenAccount() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String postCode = faker.address().zipCode();

        managerLoginPage.loginAsManager();
        managerLoginPage.navigateToAddCustomer();

        customerManagementPage.addCustomer(firstName, lastName, postCode);

        managerLoginPage.navigateToOpenAccount();
        accountManagementPage.openAccount(firstName + " " + lastName, "Dollar");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

