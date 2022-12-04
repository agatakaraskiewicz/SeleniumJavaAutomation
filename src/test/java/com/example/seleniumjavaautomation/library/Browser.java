package com.example.seleniumjavaautomation.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    static WebDriver driver;

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
}
