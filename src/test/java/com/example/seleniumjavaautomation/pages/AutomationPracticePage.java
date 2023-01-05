package com.example.seleniumjavaautomation.pages;

import com.example.seleniumjavaautomation.data.AutomationPracticeData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticePage {
    @FindBy(id = AutomationPracticeData.NAME_INPUT_ID)
        private WebElement nameInput;

    @FindBy(id = AutomationPracticeData.ALERT_BUTTON_ID)
        private WebElement alertButton;

    @FindBy(id = AutomationPracticeData.CONFIRM_BUTTON_ID)
        private WebElement confirmButton;


    public void provideName(String name) {
        nameInput.sendKeys(name);
    }

    public void clickAlertButton() {
        alertButton.click();
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }
}
