package com.example.seleniumjavaautomation.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Browser {
    public static WebDriver driver;

    public static WebDriver StartBrowser(String browserName, String url){
        switch (browserName){
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void closeDriver() {
        driver.close();
    }

    public static void checkUrl(String url){
        String actualUrl = driver.getCurrentUrl();
        assertEquals(actualUrl, url);
    }

    public static void checkTitle(String title){
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, title);
    }
}
