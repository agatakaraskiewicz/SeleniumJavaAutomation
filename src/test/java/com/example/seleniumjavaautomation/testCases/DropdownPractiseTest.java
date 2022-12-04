package com.example.seleniumjavaautomation.testCases;

import com.example.seleniumjavaautomation.data.DropdownsPractiseData;
import com.example.seleniumjavaautomation.library.Browser;
import com.example.seleniumjavaautomation.pages.DropdownsPractisePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static com.example.seleniumjavaautomation.library.Browser.*;
import static io.qameta.allure.Allure.step;

public class DropdownPractiseTest {

    private DropdownsPractisePage dropdownPractisePage;

    @BeforeClass
    public void openBrowserAndInit() {
        Browser.StartBrowser("Chrome", DropdownsPractiseData.URL);
        //initialize Web Elements
        dropdownPractisePage = PageFactory.initElements(Browser.getDriver(), DropdownsPractisePage.class);
    }

    @Test
    @Tag("static_dropdown")
    @DisplayName("Verify if there is a possibility to change currency")
    public void staticCurrencyDropdownWithSelect() {

        step("Check if the url is correct", () -> {
            Browser.checkUrl(DropdownsPractiseData.URL);
        });

        step("Change currency to USD and verify if the change was applied (by id of the option)", () -> {
            dropdownPractisePage.changeStaticCurrencyByIndex(3);
        });

        step("Change currency to INR and verify if the change was applied (by id of the option)", () -> {
            dropdownPractisePage.changeStaticCurrencyByIndex(1);
        });

        step("Change currency to 'Select' and verify if the change was applied (by id of the option)", () -> {
            dropdownPractisePage.changeStaticCurrencyByIndex(0);
        });

        step("Change currency to AED and verify if the change was applied (by id of the option)", () -> {
            dropdownPractisePage.changeStaticCurrencyByIndex(2);
        });

        step("Change currency to 'Select' and verify if the change was applied (by value of the option)", () -> {
            dropdownPractisePage.changeStaticCurrencyByValue("AED");
        });

    }

    @AfterClass
    public void closeBrowser() {
        closeDriver();
    }

}
