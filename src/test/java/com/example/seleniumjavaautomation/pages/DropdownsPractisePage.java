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
            case 1 :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "INR");
            case 2 :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "AED");
            case 3 :
                assertEquals(currencyDropdown.getFirstSelectedOption().getText(), "USD");
        }
    }
}
