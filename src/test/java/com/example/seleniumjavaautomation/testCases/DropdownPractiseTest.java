package com.example.seleniumjavaautomation.testCases;

import com.example.seleniumjavaautomation.pages.DropdownsPractisePageObjects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

public class DropdownPractiseTest extends DropdownsPractisePageObjects {
    private static ChromeDriver driver;

    @BeforeClass
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();

        driver.get(DropdownsPractisePageObjects.URL);
    }

    @Test
    @Tag("static_dropdown")
    @DisplayName("Verify if there is a possibility to change currency")
    public void staticCurrencyDropdownWithSelect() {
        step("Check the tab has correct name", () -> {
            String title = driver.getTitle();
            System.out.println(title);
            assertEquals(title, PAGE_TITLE);
        });

        step("Check if the url is correct", () -> {
            String url = driver.getCurrentUrl();
            System.out.println(url);
            assertEquals(url, URL);
        });

        step("Change currency to USD and verify if the change was applied", () -> {
            WebElement staticCurrencyDropdown = driver.findElement(new By.ByXPath(CURRENCY_DROPDOWN_XPATH));
            Select currencyDropdown = new Select(staticCurrencyDropdown);
            currencyDropdown.selectByIndex(3);
            assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "USD");
        });

    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }

}
