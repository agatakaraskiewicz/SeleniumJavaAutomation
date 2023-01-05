package com.example.seleniumjavaautomation.pages;

import com.example.seleniumjavaautomation.data.DropdownsPractiseData;
import com.example.seleniumjavaautomation.library.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.testng.Assert.*;

public class DropdownsPractisePage {
    
    @FindBy(xpath = DropdownsPractiseData.CURRENCY_DROPDOWN_XPATH)
        private WebElement staticCurrencyDropdown;

    @FindBy(xpath = DropdownsPractiseData.PASSENGERS_INPUT_XPATH)
        private WebElement passengersInput;

    @FindBy(xpath = DropdownsPractiseData.PASSENGERS_OPTIONS_XPATH)
        private WebElement passengersOptions;

    @FindBy(id = DropdownsPractiseData.PASSENGERS_ADULT_ADD_ID)
        private WebElement addAdultPassengerButton;

    @FindBy(id = DropdownsPractiseData.PASSENGERS_ADULT_SUBTRACT_ID)
        private WebElement subtractAdultPassengerButton;

    @FindBy(id = DropdownsPractiseData.PASSENGERS_ADULT_AMOUNT_ID)
        private WebElement currentAmountOfAdultPassengers;

    @FindBy(id = DropdownsPractiseData.PASSENGERS_DONE_BTN_ID)
        private WebElement passengersOptionsDoneBtn;

    @FindBy(id = DropdownsPractiseData.DEPARTURE_CITY_INPUT_ID)
        private WebElement departureCityInput;

    @FindBy(xpath = DropdownsPractiseData.DEPARTURE_CITIES_LIST_XPATH)
        private WebElement departureCitiesList;

    @FindBy(xpath = DropdownsPractiseData.ARRIVAL_CITIES_LIST_XPATH)
        private WebElement arrivalCitiesList;

    @FindBy(id = DropdownsPractiseData.ARRIVAL_CITY_INPUT_ID)
        private WebElement arrivalCityInput;

    @FindBy(id = DropdownsPractiseData.ARRIVAL_CITY_INPUT_ARROW_ID)
        private WebElement arrivalCityInputArrow;

    @FindBy(id = DropdownsPractiseData.COUNTRY_INPUT_ID)
        private WebElement countryInput;

    @FindBy(xpath = DropdownsPractiseData.COUNTRY_AUTOSUGGESTION_LIST_XPATH)
        private List<WebElement> countryAutosuggestionList;

    @FindBy(xpath = DropdownsPractiseData.DISCOUNT_OPTIONS_CHECKBOXES_XPATH)
        private WebElement discountOptionsCheckboxes;

    @FindBy(xpath = DropdownsPractiseData.DISCOUNT_CHECKBOXES_TYPE_XPATH)
        private List<WebElement> discountCheckboxes;

    @FindBy(xpath = DropdownsPractiseData.TRIP_ONEWAY_XPATH)
        private WebElement oneWayTripRadio;

    @FindBy(xpath = DropdownsPractiseData.TRIP_ROUND_XPATH)
        private WebElement roundTripRadio;

    @FindBy(xpath = DropdownsPractiseData.TRIP_MULTI_XPATH)
        private WebElement multicityTripRadio;

    @FindBy(xpath = DropdownsPractiseData.DEPARTURE_DATE_BUTTON_XPATH)
        private WebElement departureDateButton;

    @FindBy(id = DropdownsPractiseData.DATE_PICKER_ID)
        private WebElement datePicker;

    @FindBy(xpath = DropdownsPractiseData.CURRENT_DATE_HIGHLIGHTED_XPATH)
        private WebElement currentDateHighlighted;

    @FindBy(id = DropdownsPractiseData.ACTUAL_DEPARTURE_DATE_ID)
        private WebElement actualDepartureDate;

    @FindBy(id = DropdownsPractiseData.RETURN_DATE_BOX_ID)
        private WebElement returnDateBox;

    @FindBy(id = DropdownsPractiseData.SEARCH_BUTTON_ID)
        private WebElement searchButton;


    public void changeStaticCurrencyByIndex(int currencyIndex){
        Select currencyDropdown = new Select(staticCurrencyDropdown);
        currencyDropdown.selectByIndex(currencyIndex);
        //different assertions for changed currency - depending on the argument provided
        switch (currencyIndex){
            case 0 :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "Select");
                break;
            case 1 :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "INR");
                break;
            case 2 :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "AED");
                break;
            case 3 :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "USD");
                break;
        }
    }

    public void changeStaticCurrencyByValue(String currencyValue){
        Select currencyDropdown = new Select(staticCurrencyDropdown);
        currencyDropdown.selectByValue(currencyValue);
        //different assertions for changed currency - depending on the argument provided
        switch (currencyValue){
            case "INR" :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "INR");
                break;
            case "AED" :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "AED");
                break;
            case "USD" :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "USD");
                break;
        }
    }

    public void changeStaticCurrencyByText(String currencyText){
        Select currencyDropdown = new Select(staticCurrencyDropdown);
        currencyDropdown.selectByVisibleText(currencyText);
        //different assertions for changed currency - depending on the argument provided
        switch (currencyText){
            case "Select" :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "Select");
                break;
            case "INR" :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "INR");
                break;
            case "AED" :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "AED");
                break;
            case "USD" :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "USD");
                break;
        }
    }

    //clicks on the passengers input to open drop-down and then asserts if the drop-down is visible
    public void openPassengersInput() throws InterruptedException {
        passengersInput.click();
        //here is small sleep needed - otherwise the buttons are not active (needed for other methods)
        Thread.sleep(1000);
        assertTrue(passengersOptions.isDisplayed());
    }

    //only after openPassengersInput()
    //clicks on '+' button next to the ADULT option and asserts if the number of passengers changed
    public void addOneAdultPassenger() {
        int initialPassengerAmount = Integer.parseInt(currentAmountOfAdultPassengers.getText());
        addAdultPassengerButton.click();
        assertEquals(Integer.parseInt(currentAmountOfAdultPassengers.getText()), initialPassengerAmount + 1);
    }

    //only after openPassengersInput()
    //clicks on 'Done' button to apply the changes and asserts if passengers drop-down was closed
    public void applyPassengersChanges() {
        passengersOptionsDoneBtn.click();
        assertFalse(passengersOptions.isDisplayed());
    }

    //only after openPassengersInput()
    //takes desired amount of adult passengers; checks what is initial number and while it is not equal the desired number
    //it adds or subtracts passengers. If the provided amount is <= 0 then it sets the desired to the lowest possible
    //If the provided amount is >= 10 then it is set to the desired highest possible + console info
    public void changeAmountOfAdultsTo(int desiredAmount) {
        int initialAdultsAmount = Integer.parseInt(currentAmountOfAdultPassengers.getText());

        while (initialAdultsAmount != desiredAmount) {
            if (initialAdultsAmount > desiredAmount && desiredAmount > 0 && desiredAmount < 10){
                subtractAdultPassengerButton.click();
            } else if (initialAdultsAmount < desiredAmount && desiredAmount > 0 && desiredAmount < 10){
                addAdultPassengerButton.click();
            } else if (desiredAmount >= 10) {
                //for now highest possible amount of adults is 9
                System.out.println("You try to have " + desiredAmount + " adult passengers");
                desiredAmount = 9;
                System.out.println("Your desired amount was set to 9 - this is the highest possible");
            } else {
                //for now the lowest possible amount of adults is 1
                System.out.println("You try to have " + desiredAmount + " adult passengers");
                desiredAmount = 1;
                System.out.println("Your desired amount was set to 1 - this is the lowest possible");
            }
            initialAdultsAmount = Integer.parseInt(currentAmountOfAdultPassengers.getText());
        }
        //this is kinda not necessary as the above loop will work until these values will be equal, but I feel it is nice to have assertions everywhere
        assertEquals(desiredAmount, initialAdultsAmount);
    }

    public void openDepartureCityDropDown() {
        departureCityInput.click();
        assertTrue(departureCitiesList.isDisplayed());
    }

    public void pickDepartureCity(String departureCity) throws InterruptedException {
        departureCitiesList.findElement(By.xpath("//descendant::a[contains(text(), '" + departureCity + "')]")).click();
        Thread.sleep(1000);
        assertFalse(departureCitiesList.isDisplayed());
        assertEquals(departureCityInput.getAttribute("selectedtext"), departureCity);
        assertTrue(arrivalCitiesList.isDisplayed());

    }

    public void pickArrivalCity(String arrivalCity) throws InterruptedException {
        //it has to sendKeys as there were issues with clicking on the city option (elements not interactable)
        arrivalCityInput.sendKeys(arrivalCity);
        Thread.sleep(1000);
        assertFalse(arrivalCitiesList.isDisplayed());
        assertEquals(arrivalCityInput.getAttribute("value"), arrivalCity);
        assertTrue(datePicker.isDisplayed());
    }

    public void closeArrivalCityDropDown() throws InterruptedException {
        arrivalCityInputArrow.click();
        Thread.sleep(1000);
        assertFalse(arrivalCitiesList.isDisplayed());
    }

    public void countryTypeToSelectPoland() throws InterruptedException {
        countryInput.sendKeys("pol");
        Thread.sleep(3000);

        //create list of actual and suggested countries and compare them
        List<String> actualSuggestedList = GlobalMethods.makeListOfTextInElements(countryAutosuggestionList);
        List<String> expectedSuggestedList = Arrays.asList("France Metropolitan", "French Polynesia", "Poland");
        assertEquals(expectedSuggestedList, actualSuggestedList);

        //iterate by WebElement list and click on Poland when found
        for (WebElement countryOption:countryAutosuggestionList) {
            if (countryOption.getText().equalsIgnoreCase("poland")) {
                countryOption.click();
                break;
            }
        }

    }

    public void discountOptionPickAndClick(String specialOption) {
        specialOption = specialOption.toLowerCase(Locale.ROOT);
        switch (specialOption) {
            case "family and friends":
                discountOptionsCheckboxes.findElement(By.xpath("//descendant::input[contains(@id," + DropdownsPractiseData.DISCOUNT_FRIENDS_AND_FAM_ID_ENDING + ")]")).click();
                assertTrue(discountOptionsCheckboxes.findElement(By.xpath("//descendant::input[contains(@id," + DropdownsPractiseData.DISCOUNT_FRIENDS_AND_FAM_ID_ENDING + ")]")).isSelected());
                break;
            case "senior citizen":
                discountOptionsCheckboxes.findElement(By.xpath("//descendant::input[contains(@id," + DropdownsPractiseData.DISCOUNT_SENIOR_ID_ENDING + ")]")).click();
                assertTrue(discountOptionsCheckboxes.findElement(By.xpath("//descendant::input[contains(@id," + DropdownsPractiseData.DISCOUNT_SENIOR_ID_ENDING + ")]")).isSelected());
                break;
            case "indian armed forces":
                discountOptionsCheckboxes.findElement(By.xpath("//descendant::input[contains(@id," + DropdownsPractiseData.DISCOUNT_INDIAN_AF_ENDING + ")]")).click();
                assertTrue(discountOptionsCheckboxes.findElement(By.xpath("//descendant::input[contains(@id," + DropdownsPractiseData.DISCOUNT_INDIAN_AF_ENDING + ")]")).isSelected());
                break;
            case "student":
                discountOptionsCheckboxes.findElement(By.xpath("//descendant::input[contains(@id," + DropdownsPractiseData.DISCOUNT_STUDENT_ENDING + ")]")).click();
                assertTrue(discountOptionsCheckboxes.findElement(By.xpath("//descendant::input[contains(@id," + DropdownsPractiseData.DISCOUNT_STUDENT_ENDING + ")]")).isSelected());
                break;
            case "unaccompanied minor":
                discountOptionsCheckboxes.findElement(By.xpath("//descendant::input[contains(@id," + DropdownsPractiseData.DISCOUNT_LONELY_MINOR_ENDING + ")]")).click();
                assertTrue(discountOptionsCheckboxes.findElement(By.xpath("//descendant::input[contains(@id," + DropdownsPractiseData.DISCOUNT_LONELY_MINOR_ENDING + ")]")).isSelected());
                break;
        }
    }

    public void checkNumberOfCheckboxes(int expectedNumber) {
        assertEquals(discountCheckboxes.size(), expectedNumber);
    }

    //method takes input and changes checked radio button; then it checks if the Return Date box is in correct state
    public void changeTripTypeTo(String newTripType) {
        newTripType = newTripType.toLowerCase(Locale.ROOT);

        switch (newTripType) {
            case "one way":
                oneWayTripRadio.click();
                assertTrue(oneWayTripRadio.isSelected());
                assertTrue(checkReturnDateBoxState("not active"));
                break;
            case "round trip":
                roundTripRadio.click();
                assertTrue(roundTripRadio.isSelected());
                assertTrue(checkReturnDateBoxState("active"));
                break;
            case "multicity":
                multicityTripRadio.click();
                assertTrue(multicityTripRadio.isSelected());
                break;
        }
    }

    public void changeDepartureDateToCurrent() {
        //check if the date picker is present - if not, open it
        if (!datePicker.isDisplayed()) {
            departureDateButton.click();
            assertTrue(datePicker.isDisplayed());
        }

        //click on the current date and verify if it was actually picked
        currentDateHighlighted.click();
        assertEquals(actualDepartureDate.getText(), GlobalMethods.currentDateFormatter());
    }

    //method checks if the state of the return date box is as expected; returns boolean; could be used as condition in assertions
    public boolean checkReturnDateBoxState(String expectedState) {
        if (expectedState.equals("active")){
            return returnDateBox.getAttribute("style").contains("opacity: 1;");
        } else { //not active
            return returnDateBox.getAttribute("style").contains("opacity: 0.5;");
        }
    }

    public void clickOnSearch() throws InterruptedException {
        searchButton.click();
        Thread.sleep(2000);
    }
}
