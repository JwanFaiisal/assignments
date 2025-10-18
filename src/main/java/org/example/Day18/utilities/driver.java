package org.example.Day18.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.time.Duration;

public class driver {
    private static WebDriver driverInstance;

    public static WebDriver getDriver(String browser, String gridURL) {
        if (driverInstance == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setBrowserName(browser);
                driverInstance = new RemoteWebDriver(new URL(gridURL), caps);
                driverInstance.manage().window().maximize();
                driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } catch (Exception e) {
                throw new RuntimeException("❌ Failed to connect to Selenium Grid: " + e.getMessage());
            }
        }
        return driverInstance;
    }

    public static void closeDriver() {
        if (driverInstance != null) {
            driverInstance.quit();
            driverInstance = null;
        }
    }
}
