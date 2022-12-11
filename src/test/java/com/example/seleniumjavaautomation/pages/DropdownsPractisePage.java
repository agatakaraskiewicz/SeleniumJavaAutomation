package com.example.seleniumjavaautomation.pages;

import com.example.seleniumjavaautomation.data.DropdownsPractiseData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

}
