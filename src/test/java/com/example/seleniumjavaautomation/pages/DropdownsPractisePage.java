package com.example.seleniumjavaautomation.pages;

import com.example.seleniumjavaautomation.data.DropdownsPractiseData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class DropdownsPractisePage {
    
    @FindBy(xpath = DropdownsPractiseData.CURRENCY_DROPDOWN_XPATH)
        private WebElement staticCurrencyDropdown;


    public void changeStaticCurrencyByIndex(int currencyIndex){
        Select currencyDropdown = new Select(staticCurrencyDropdown);
        currencyDropdown.selectByIndex(currencyIndex);
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
        switch (currencyValue){
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
}
