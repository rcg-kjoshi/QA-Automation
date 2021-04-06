package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FirstTest {

    WebDriver driver;

    @Test
    public void Testbrowser () throws InterruptedException {

       /* System.setProperty("webdriver.chrome.driver","/Macintosh HD/Users/krupaljoshi/Desktop/Krupal Selenium/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.amazon.com");
*/
        // Instantiate a SafariDriver class.
       /* driver = new SafariDriver();
        driver.get("http://www.amazon.com");
        Thread.sleep(2000);
        driver.close();
*/
        System.setProperty("webdriver.chrome.driver","/Users/krupaljoshi/Desktop/Krupal Selenium/chromedriver");
            driver = new ChromeDriver(); //init chrome driver
        driver.get("http://www.amazon.com");

       // driver.navigate().to("https://test.abeka.com");

        Thread.sleep(2000);


        driver.close();

        //Thread.sleep(2000);
        //driver.close();
    }
}
