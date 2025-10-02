package org.example.Day13;


import org.example.Day13.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Example2BankingApplicationTest {
    WebDriver driver;
    ManagerLoginPage managerLoginPage;
    CustomerManagementPage customerManagementPage;
    AccountManagementPage accountManagementPage;
    CustomerLoginPage customerLoginPage;
    TransactionPage transactionPage;

    String[] customers = {"Ali Saleh", "Sara Ahmed", "Omar Hassan", "Mona Khalid", "Yousef Zain"};

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        managerLoginPage = new ManagerLoginPage(driver);
        customerManagementPage = new CustomerManagementPage(driver);
        accountManagementPage = new AccountManagementPage(driver);
        customerLoginPage = new CustomerLoginPage(driver);
        transactionPage = new TransactionPage(driver);
    }

    @Test(priority = 1)
    public void testCustomerAccountFlow() {
        managerLoginPage.loginAsManager();

        // 1. Add 5 new customers
        for (String customer : customers) {
            String[] split = customer.split(" ");
            managerLoginPage.goToAddCustomer();
            customerManagementPage.addCustomer(split[0], split[1], "12345");
        }

        // 2. Open accounts for each customer
        for (String customer : customers) {
            managerLoginPage.goToOpenAccount();
            accountManagementPage.openAccount(customer, "Dollar");
        }

        // 3. Deposit 100 for each customer
        for (String customer : customers) {
            customerLoginPage.loginAsCustomer(customer);
            transactionPage.deposit(100);
            Assert.assertEquals(transactionPage.getBalance(), 100, "Deposit failed for " + customer);
            driver.navigate().back();
        }

        // 4. Withdraw 100 from first customer
        customerLoginPage.loginAsCustomer(customers[0]);
        transactionPage.withdraw(100);
        Assert.assertEquals(transactionPage.getBalance(), 0, "Withdraw failed!");
        driver.navigate().back();

        // 5. Delete all created customers
        managerLoginPage.loginAsManager();
        managerLoginPage.goToCustomers();
        for (String customer : customers) {
            driver.findElement(org.openqa.selenium.By.xpath("//td[contains(text(),'" + customer.split(" ")[0] + "')]/../td/button")).click();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
