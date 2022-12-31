package com.example.seleniumjavaautomation.testCases;

import com.example.seleniumjavaautomation.library.GlobalMethods;
import com.example.seleniumjavaautomation.data.DropdownsPractiseData;
import com.example.seleniumjavaautomation.library.Browser;
import com.example.seleniumjavaautomation.pages.DropdownsPractisePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.example.seleniumjavaautomation.library.Browser.*;
import static io.qameta.allure.Allure.step;

public class DropdownPractiseTest {

    private DropdownsPractisePage dropdownPractisePage;
    private GlobalMethods globalMethods;


    @BeforeEach
    public void openBrowserAndCheck() {
        //initialize WebDriver
        Browser.StartBrowser("Chrome", DropdownsPractiseData.URL);

        //initialize other used classes
        dropdownPractisePage = PageFactory.initElements(Browser.getDriver(), DropdownsPractisePage.class);
        globalMethods = PageFactory.initElements(Browser.getDriver(), GlobalMethods.class);

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
            List<String> availableCurrencyOptions = Arrays.asList("Select", "AED", "USD", "INR");
            for (String currencyOption : availableCurrencyOptions) {
                dropdownPractisePage.changeStaticCurrencyByText(currencyOption);
            }
        });

    }

    @Test
    @Tag("dynamic_dropdown")
    @DisplayName("Verify if there is a possibility to pick number of Adult passengers")
    public void passengersDropdown() {
        step("Click on the passengers input, add 1 Adult and apply change", () -> {
            dropdownPractisePage.openPassengersInput();
            dropdownPractisePage.addOneAdultPassenger();
            dropdownPractisePage.applyPassengersChanges();
        });

        step("Click on the passenger input, pick some random number of Adults and apply change", () -> {
           dropdownPractisePage.openPassengersInput();
           dropdownPractisePage.changeAmountOfAdultsTo(globalMethods.randomIntInRange(1, 9));
           dropdownPractisePage.applyPassengersChanges();
        });

        step("Click on the passengers input, add 3 then change to 9 then change to 0 (it will be 1) then to 5 and then to 7 Adults and apply change", () -> {
            dropdownPractisePage.openPassengersInput();

            //create a list of Adult's numbers and then iterate changing the amount
            List<Integer> amountOfAdultsForTest = Arrays.asList(
                    3, 9, 0, 5, 7
            );
            for (Integer num:amountOfAdultsForTest) {
                dropdownPractisePage.changeAmountOfAdultsTo(num);
            }

            dropdownPractisePage.applyPassengersChanges();
        });
    }

    @Test
    @Tag("dynamic_dropdown")
    @DisplayName("Verify if there is a possibility to pick a departure/arrival city")
    public void changeDepartureCity() {
        step("Open the departure drop-down and change to Jaipur, check if the arrival city dropdown opens automatically and close it", () -> {
            dropdownPractisePage.openDepartureCityDropDown();
            dropdownPractisePage.pickDepartureCity("Jaipur (JAI)");
            dropdownPractisePage.closeArrivalCityDropDown();
        });

    }

    @Test
    @Tag("auto-suggestive_dropdown")
    @DisplayName("Verify if auto-suggestive dropdown presents correct options to the User")
    public void changeCountry() {
        step("Input 'pol' into country input and check the suggested options", () -> {
            dropdownPractisePage.countryTypeToSelectPoland();
        });
    }

    @AfterEach
    public void closeBrowser() {
        closeDriver();
    }
}
