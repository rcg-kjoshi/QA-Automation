package com.amazon;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginDemo {

    WebDriver driver;

    Map<String, String> credentialList = userCredentialList();

    public LoginDemo() throws IOException {
    }

    @Test
    public void testABALogin() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/krupaljoshi/Desktop/Krupal Selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://test.abeka.com");

        Thread.sleep(5000);

        String emailId;

        for(int i = 0;i<credentialList.size();i++) {

            emailId = credentialList.keySet().stream().toArray()[i].toString();

            driver.findElement(By.linkText("Log in")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Log in / Create Account")).click();
            Thread.sleep(3000);

            driver.findElement(By.id("txtEmailAddress")).click();
            //driver.findElement(By.id("txtEmailAddress")).sendKeys("rcg@pcci.edu");
            driver.findElement(By.id("txtEmailAddress")).sendKeys(emailId);

            driver.findElement(By.id("txtPassword")).click();
            //driver.findElement(By.id("txtPassword")).sendKeys("RCG1234");
            driver.findElement(By.id("txtPassword")).sendKeys(credentialList.get(emailId).trim());

            driver.findElement(By.id("lbnLogin")).click();
            Thread.sleep(5000);

            driver.findElement(By.partialLinkText("Hello")).click();
            Thread.sleep(3000);

            driver.findElement(By.linkText("Log out")).click();
        }
        driver.close();

    }

    public Map<String, String> userCredentialList() throws IOException {
        File file = new File("/Users/krupaljoshi/Desktop/Krupal Selenium/login.xls");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook loginCredentialFile = new HSSFWorkbook(fileInputStream);
        Sheet sheet = loginCredentialFile.getSheet("details");
        Row row;
        String userName;
        String password;
        Map<String, String> credentialMap = new HashMap<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            userName = row.getCell(0).getStringCellValue().trim();
            password = row.getCell(1).getStringCellValue().trim();
            credentialMap.put(userName, password);

        }
        return credentialMap;


    }
}


