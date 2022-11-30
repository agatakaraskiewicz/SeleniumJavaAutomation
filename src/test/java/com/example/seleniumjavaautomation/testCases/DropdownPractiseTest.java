package com.example.seleniumjavaautomation.testCases;

import com.example.seleniumjavaautomation.pages.DropdownsPractisePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static com.example.seleniumjavaautomation.library.Browser.*;
import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

public class DropdownPractiseTest {
    WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        driver = StartBrowser("Chrome", DropdownsPractisePage.URL);
    }

    @Test
    @Tag("static_dropdown")
    @DisplayName("Verify if there is a possibility to change currency")
    public void staticCurrencyDropdownWithSelect() {
        step("Check the tab has correct name", () -> {
            String title = driver.getTitle();
            System.out.println(title);
            assertEquals(title, DropdownsPractisePage.PAGE_TITLE);
        });

        step("Check if the url is correct", () -> {
            String url = driver.getCurrentUrl();
            System.out.println(url);
            assertEquals(url, DropdownsPractisePage.URL);
        });

        step("Change currency to USD and verify if the change was applied (by id of the option)", () -> {
            WebElement staticCurrencyDropdown = driver.findElement(new By.ByXPath(DropdownsPractisePage.CURRENCY_DROPDOWN_XPATH));
            Select currencyDropdown = new Select(staticCurrencyDropdown);
            currencyDropdown.selectByIndex(3);
            assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "USD");
        });

        step("Change currency to AED and verify if the change was applied (by the visible text)", () -> {
            WebElement staticCurrencyDropdown = driver.findElement(new By.ByXPath(DropdownsPractisePage.CURRENCY_DROPDOWN_XPATH));
            Select currencyDropdown = new Select(staticCurrencyDropdown);
            currencyDropdown.selectByVisibleText("AED");
            assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "AED");
        });

        step("Change currency to AED and verify if the change was applied (by the value)", () -> {
            WebElement staticCurrencyDropdown = driver.findElement(new By.ByXPath(DropdownsPractisePage.CURRENCY_DROPDOWN_XPATH));
            Select currencyDropdown = new Select(staticCurrencyDropdown);
            currencyDropdown.selectByValue("INR");
            assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "INR");
        });

    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }

}
