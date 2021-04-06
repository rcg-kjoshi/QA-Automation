package com.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserTesting {
    WebDriver driver = null;

    @Parameters("browserName")
    @BeforeTest
    public void setup(String browserName) {
        System.out.println("Browser Name is: " + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/krupaljoshi/Desktop/Krupal Selenium/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
            driver.manage().window().maximize();
        }
    }

    @Test
    public void testLaunch() throws InterruptedException {
        driver.navigate().to("https://test.abeka.com");
        Thread.sleep(5000);
    }

    @AfterTest
    public void teardown () {
        driver.close();

    }
}


