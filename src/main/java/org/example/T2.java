package org.example;
import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T2 {
        public static void main(String[] args)  {

            //1
            WebDriver driver = new FirefoxDriver();

            // 2
            driver.navigate().to("https://www.youtube.com");

            //2
            String title = driver.getTitle();
            String expectedKeyword = "video";  // تعريف الكلمة المتوقعة في العنوان
            if (title.toLowerCase().contains(expectedKeyword.toLowerCase())) {
                System.out.println("Test Passed: Title contains the word '" + expectedKeyword + "'");
            } else {
                System.out.println("Test Failed: Title does not contain the word '" + expectedKeyword + "'");
                System.out.println("Actual title was: " + title);
            }


            // 4
            driver.quit();

    }
    }




