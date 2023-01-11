package com.example.seleniumjavaautomation.pages;

import com.example.seleniumjavaautomation.data.SeleniumPracticeData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumPracticePage {

    @FindBy(xpath = SeleniumPracticeData.PRODUCTS_XPATH)
        private WebElement product;

//    @FindBy(xpath = SeleniumPracticeData.ADD_TO_CART_BUTTON_XPATH)
//        private WebElement addToCartButton;



    public void addListOfProductsToCart(List<String> productsToBeAdded) {
        for (String itemToBeAdded : productsToBeAdded) {
            String buttonXpath = "//child::h4[contains(text(), '" + itemToBeAdded +"')]//following-sibling::div[@class='product-action']//child::button";
            product.findElement(By.xpath(buttonXpath)).click();
            assertEquals("✔ ADDED", product.findElement(By.xpath(buttonXpath)).getText());
        }

    }
}
