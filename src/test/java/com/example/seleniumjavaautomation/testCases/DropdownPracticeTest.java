package com.example.seleniumjavaautomation.testCases;

import com.example.seleniumjavaautomation.library.GlobalMethods;
import com.example.seleniumjavaautomation.data.DropdownsPracticeData;
import com.example.seleniumjavaautomation.library.Browser;
import com.example.seleniumjavaautomation.pages.DropdownsPracticePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.example.seleniumjavaautomation.library.Browser.*;
import static io.qameta.allure.Allure.step;

public class DropdownPracticeTest {

    private DropdownsPracticePage dropdownPractisePage;
    private GlobalMethods globalMethods;


    @BeforeEach
    public void openBrowserAndCheck() {
        //initialize WebDriver
        Browser.StartBrowser("Chrome", DropdownsPracticeData.URL);

        //initialize other used classes
        dropdownPractisePage = PageFactory.initElements(Browser.getDriver(), DropdownsPracticePage.class);
        globalMethods = PageFactory.initElements(Browser.getDriver(), GlobalMethods.class);

        step("Check if the tab has correct name", () -> {
            Browser.checkTitle(DropdownsPracticeData.PAGE_TITLE);
        });

        step("Check if the url is correct", () -> {
            Browser.checkUrl(DropdownsPracticeData.URL);
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

    @Test
    @Tag("checkboxes")
    @DisplayName("Verify if there is possibility to pick discount options")
    public void pickDiscountOptions() {

        step("Check if there are 6 checkboxes on the page", () -> {
            dropdownPractisePage.checkNumberOfCheckboxes(6);
        });

        step("Check 'Friends and Family' checkbox", () -> {
            dropdownPractisePage.discountOptionPickAndClick("Family and Friends");
            dropdownPractisePage.discountOptionPickAndClick("Senior Citizen");
            dropdownPractisePage.discountOptionPickAndClick("Indian Armed Forces");
            dropdownPractisePage.discountOptionPickAndClick("Student");
            dropdownPractisePage.discountOptionPickAndClick("Unaccompanied Minor");
        });
    }

    @Test
    @Tag("radio_buttons")
    @Tag("calendar")
    @DisplayName("Verify if there is possibility to set departure date to current day")
    public void changeDepartureDateToCurrentDay() {

        step("Change departure date to current date", () -> {
            dropdownPractisePage.changeDepartureDateToCurrent();
        });
    }

    @Test
    @Tag("radio_buttons")
    @DisplayName("Verify if changing type of trip disables and enables calendar options")
    public void changeTripType() {
        step("Change type of trip to 'Round Trip' to have 'Return Date' calendar active", () -> {
            dropdownPractisePage.changeTripTypeTo("Round Trip");
            //we could have this assertion also here, but above .changeTripTypeTo has it built in
            //Assertions.assertTrue(dropdownPractisePage.checkReturnDateBoxState("active"));
        });

        step("Change type of trip to 'One Way' to have 'Return Date' calendar not active", () -> {
            dropdownPractisePage.changeTripTypeTo("One Way");
        });
    }

    @Test
    @Tag("E2E")
    @DisplayName("Verify if you can search for One Way Trip from Jaipur to Goa for 3 Adults (USD)")
    public void searchOneWayJaipurGoa3Adults() {
        step("Change trip type to 'One Way'", () -> {
            dropdownPractisePage.changeTripTypeTo("One Way");
        });

        step("Change departure city to Jaipur", () -> {
            dropdownPractisePage.openDepartureCityDropDown();
            dropdownPractisePage.pickDepartureCity("Bangkok (BKK)");
        });

        step("Change arrival city to Goa", () -> {
            //arrival city drop-down is opened automatically (asserted in previous step)
            dropdownPractisePage.pickArrivalCity("Goa (GOI)");
        });

        step("Change departure date to current day", () -> {
           dropdownPractisePage.changeDepartureDateToCurrent();
        });

        step("Change number od adult passengers to 3", () ->{
            dropdownPractisePage.openPassengersInput();
           dropdownPractisePage.changeAmountOfAdultsTo(3);
            dropdownPractisePage.applyPassengersChanges();
        });

        step("Change currency to USD", () -> {
            dropdownPractisePage.changeStaticCurrencyByText("USD");
        });

        step("Click on search button and verify if the URL changed", () -> {
            dropdownPractisePage.clickOnSearch();
            checkUrl(DropdownsPracticeData.URL_SEARCH_MODE);
        });
    }

    @AfterEach
    public void closeBrowser() {
        closeDriver();
    }
}
