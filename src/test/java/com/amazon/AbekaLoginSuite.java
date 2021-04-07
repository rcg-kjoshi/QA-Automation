package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AbekaLoginSuite {
    WebDriver driver;
    WebDriverWait driverWait;

    @Test
    public void testdemo(){
        System.out.println("Demo test");
    }

    @Test(dataProvider="Credentials", dataProviderClass = DataFetcher.class)
    public void testAbekaLogin(Object[] credentialList) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/krupaljoshi/Desktop/Krupal Selenium/chromedriver");
        driver = new ChromeDriver();

        driverWait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.navigate().to("https://test.abeka.com");
        Thread.sleep(3000);
        Actions action = new Actions(driver);

        //for(Object object:credentialList){

            driver.findElement(By.xpath("//a[normalize-space(text())='Log in']")).click();
            driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[normalize-space(text())='Log in / Create Account']"))));

            driver.findElement(By.xpath("//a[normalize-space(text())='Log in / Create Account']")).click();
            Thread.sleep(3000);
            //driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("txtEmailAddress"))));

            driver.findElement(By.id("txtEmailAddress")).sendKeys(credentialList[0].toString());
            driver.findElement(By.id("txtPassword")).sendKeys(credentialList[1].toString());
            driver.findElement(By.id("lbnLogin")).click();

            driver.findElement(By.partialLinkText("Hello")).click();
            Thread.sleep(3000);

            driver.findElement(By.linkText("Log out")).click();

        //}
        driver.quit();
    }

}
