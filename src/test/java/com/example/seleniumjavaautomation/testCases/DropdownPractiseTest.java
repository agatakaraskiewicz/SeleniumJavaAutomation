package com.example.seleniumjavaautomation.testCases;

import com.example.seleniumjavaautomation.data.DropdownsPractiseData;
import com.example.seleniumjavaautomation.library.Browser;
import com.example.seleniumjavaautomation.pages.DropdownsPractisePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.stream.IntStream;

import static com.example.seleniumjavaautomation.library.Browser.*;
import static io.qameta.allure.Allure.step;

public class DropdownPractiseTest {

    private DropdownsPractisePage dropdownPractisePage;

    @BeforeClass
    public void openBrowserAndInit() {
        Browser.StartBrowser("Chrome", DropdownsPractiseData.URL);
        //initialize Web Elements
        dropdownPractisePage = PageFactory.initElements(Browser.getDriver(), DropdownsPractisePage.class);

        step("Check if the tab has correct name", () -> {
            Browser.checkTitle(DropdownsPractiseData.PAGE_TITLE);
        });

        step("Check if the url is correct", () -> {
            Browser.checkUrl(DropdownsPractiseData.URL);
        });
    }

    @Test
    @Tag("static_dropdown")
    @DisplayName("Verify if there is a possibility to change currency")
    public void staticCurrencyDropdownWithSelect() {

        step("Change currency to each available option and verify if the change was applied (by id of the option)", () -> {
            IntStream.range(0,4).forEachOrdered(currencyIndex -> {
                dropdownPractisePage.changeStaticCurrencyByIndex(currencyIndex);
            });
        });

        step("Change currency to each available and verify if the change was applied (by value of the option)", () -> {
            //no 'Select' option - it has no value assigned
            dropdownPractisePage.changeStaticCurrencyByValue("AED");
            dropdownPractisePage.changeStaticCurrencyByValue("USD");
            dropdownPractisePage.changeStaticCurrencyByValue("INR");
        });

        step("Change currency to each available and verify if the change was applied (by visible text of the option)", () -> {
            dropdownPractisePage.changeStaticCurrencyByText("Select");
            dropdownPractisePage.changeStaticCurrencyByText("AED");
            dropdownPractisePage.changeStaticCurrencyByText("USD");
            dropdownPractisePage.changeStaticCurrencyByText("INR");
        });

    }

    @Test
    @Tag("d")
    @DisplayName("Verify if there is a possibility to pick number of passengers")
    public void passengersDropdown() {
        step("Click on the passengers input, add 1 Adult and apply change", () -> {
            dropdownPractisePage.openPassengersInput();
            dropdownPractisePage.addOneAdultPassenger();
            dropdownPractisePage.applyPassengersChanges();
        });
    }

    @AfterClass
    public void closeBrowser() {
        closeDriver();
    }

}
