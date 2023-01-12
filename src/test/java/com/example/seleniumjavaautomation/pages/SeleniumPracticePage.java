package com.example.seleniumjavaautomation.pages;

import com.example.seleniumjavaautomation.data.SeleniumPracticeData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumPracticePage {

    @FindBy(xpath = SeleniumPracticeData.PRODUCTS_XPATH)
        private WebElement product;

    @FindBy(xpath = SeleniumPracticeData.PRODUCTS_XPATH)
        private List<WebElement> productsList;

    @FindBy(xpath = SeleniumPracticeData.CART_INFO_XPATH)
        private WebElement cartInfo;



    public void addListOfProductsToCart(List<String> productsToBeAdded) {
        for (String itemToBeAdded : productsToBeAdded) {
            String buttonXpath = "//child::h4[contains(text(), '" + itemToBeAdded +"')]//following-sibling::div[@class='product-action']//child::button";
            product.findElement(By.xpath(buttonXpath)).click();
            assertEquals("✔ ADDED", product.findElement(By.xpath(buttonXpath)).getText());
        }

    }

    public void checkNumberOfProducts(int expectedNumberOfProducts) {
        assertEquals(expectedNumberOfProducts, productsList.size(), MessageFormat.format("There is {0} instead of {1}", productsList.size(), expectedNumberOfProducts));
    }

    public void verifyProductsOnThePage(List<String> expectedProducts) {
        //create a list of names of all actual products on the page
        List<String> actualProductsNames = new ArrayList<>();
        for (WebElement actualProduct:productsList) {
            String[] productText = actualProduct.getText().split("-", 2);
            String productName = productText[0].trim();
            actualProductsNames.add(productName);
        }

        //check if each expected name is present in the list of actual products names
        for (String expectedProduct:expectedProducts) {
            assertTrue(actualProductsNames.contains(expectedProduct), "There is no " + expectedProduct + " on the list.");
        }
    }

    public void checkCartInfo(String expectedCartInfo) throws InterruptedException {
        assertEquals(expectedCartInfo, cartInfo.getText(), MessageFormat.format("Expected:\n{0} \n Actual:\n{1}", expectedCartInfo, cartInfo.getText()));
    }
}
