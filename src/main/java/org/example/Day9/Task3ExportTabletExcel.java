package org.example.Day9;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Task3ExportTabletExcel {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Task3ExportTabletExcel.class);

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        logger.info("Browser launched successfully");
    }

    @Test
    public void writeTable1ToExcel() throws IOException {
        driver.get("https://claruswaysda.github.io/webTable.html");
        logger.info("Navigated to webTable.html");

        //د Table
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));

        //  (tr)
        List<WebElement> rows = table1.findElements(By.tagName("tr"));
        logger.info("Number of rows in Table 1: " + rows.size());

        // إنشاء ملف Excel جديد
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Table1");

        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i);

            List<WebElement> cells = rows.get(i).findElements(By.tagName("th"));
            if (cells.isEmpty()) {
                cells = rows.get(i).findElements(By.tagName("td"));
            }

            for (int j = 0; j < cells.size(); j++) {
                Cell cell = excelRow.createCell(j);
                cell.setCellValue(cells.get(j).getText());
            }
        }

        // حفظ
        try (FileOutputStream fileOut = new FileOutputStream("Table1.xlsx")) {
            workbook.write(fileOut);
        }
        workbook.close();
        logger.info("Table 1 has been written to Table1.xlsx successfully!");
    }

    @AfterAll
    public static void afterAll() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}
