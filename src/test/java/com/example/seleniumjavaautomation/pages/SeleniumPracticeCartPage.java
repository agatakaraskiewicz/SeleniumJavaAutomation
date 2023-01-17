package com.example.seleniumjavaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.example.seleniumjavaautomation.data.SeleniumPracticeCartData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumPracticeCartPage {

    @FindBy(xpath = SeleniumPracticeCartData.PROMO_CODE_INPUT_XPATH)
        private WebElement promoCodeInput;

    @FindBy(xpath = SeleniumPracticeCartData.PROMO_CODE_APPLY_BTN_XPATH)
        private WebElement promoCodeApplyButton;

    @FindBy(xpath = SeleniumPracticeCartData.DISCOUNT_PERCENTAGE_XPATH)
        private WebElement discountPercentage;




    public void inputPromoCode(String promoCode) {
        promoCodeInput.sendKeys(promoCode);
    }

    public void applyPromoCode(String expectedDiscount) {
        promoCodeApplyButton.click();
        assertEquals(expectedDiscount, discountPercentage.getText(), "Expected percentage is " + expectedDiscount + "; actual percentage is " + discountPercentage.getText());
    }
}
