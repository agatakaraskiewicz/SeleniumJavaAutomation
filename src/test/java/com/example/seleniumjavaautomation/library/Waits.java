package com.example.seleniumjavaautomation.library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.seleniumjavaautomation.library.Browser.driver;


public class Waits {

    //public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void waitUntilUrlContains(String partOfUrl, int timeOut){
        //wait.until(ExpectedConditions.urlContains(partOfUrl));
        new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.urlContains(partOfUrl));
    }

    public static void waitUntilElementAppears(WebElement desiredElement, int timeOut){
        new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.visibilityOf(desiredElement));
        //wait.until(ExpectedConditions.visibilityOf(desiredElement));
    }

    public static void waitUntilElementIsNotVisible(WebElement elementToDisappear, int timeOut){
        new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.invisibilityOf(elementToDisappear));
        //wait.until(ExpectedConditions.invisibilityOf(elementToDisappear));
    }
    
    public static void waitUntilElementIsClickable(WebElement elementToBeClicked, int timeOut) {
        new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.elementToBeClickable(elementToBeClicked));
    }
 }
