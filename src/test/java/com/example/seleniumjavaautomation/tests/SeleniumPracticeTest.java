package com.example.seleniumjavaautomation.tests;

import com.example.seleniumjavaautomation.data.SeleniumPracticeData;
import com.example.seleniumjavaautomation.library.Browser;
import com.example.seleniumjavaautomation.library.GlobalMethods;
import com.example.seleniumjavaautomation.pages.SeleniumPracticePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static com.example.seleniumjavaautomation.library.Browser.closeDriver;
import static io.qameta.allure.Allure.step;

public class SeleniumPracticeTest {

    private SeleniumPracticePage seleniumPracticePage;
    private GlobalMethods globalMethods;

    @BeforeEach
    public void openBrowserAndCheck() {
        //initialize WebDriver
        Browser.StartBrowser("Chrome", SeleniumPracticeData.SELENIUM_PRACTICE_URL);

        //initialize other used classes
        seleniumPracticePage = PageFactory.initElements(Browser.getDriver(), SeleniumPracticePage.class);
        globalMethods = PageFactory.initElements(Browser.getDriver(), GlobalMethods.class);

        step("Check if the tab has correct name", () -> {
            Browser.checkTitle(SeleniumPracticeData.SELENIUM_PRACTICE_TITLE);
        });

        step("Check if the url is correct", () -> {
            Browser.checkUrl(SeleniumPracticeData.SELENIUM_PRACTICE_URL);
        });
    }

    @Test
    @Tag("products")
    @DisplayName("Verify if the list of products is correct")
    public void checkProducts(){
        step("Check if there is correct number of products on the page", () -> {
            seleniumPracticePage.checkNumberOfProducts(30);
        });

        step("Verify if there are all expected products on the page", () -> {
            List<String> productsListToBePresent = Arrays.asList("Brocolli", "Cauliflower", "Cucumber", "Beetroot",
                    "Carrot", "Tomato", "Beans", "Brinjal", "Mushroom", "Potato", "Pumpkin", "Corn", "Onion",
                    "Apple", "Banana", "Grapes", "Mango", "Musk Melon", "Orange", "Pears", "Pomegranate", "Raspberry",
                    "Strawberry", "Water Melon", "Almonds", "Pista", "Nuts Mixture", "Cashews", "Walnuts");
            seleniumPracticePage.verifyProductsOnThePage(productsListToBePresent);
        });
    }

    @Test
    @Tag("add_to_cart")
    @DisplayName("Verify if there is possibility to add desired products to the cart")
    public void addToCart() {
        step("Add all the products from a list to the cart and check if the button changed its text to 'ADDED'", () -> {
            List<String> productsToBeAdded = Arrays.asList("Cucumber", "Beetroot", "Cauliflower", "Brinjal - 1 Kg", "Mushroom - 1 Kg", "Apple - 1 Kg", "Grapes", "Raspberry - 1/4 Kg");
            seleniumPracticePage.addListOfProductsToCart(productsToBeAdded);
        });

    }

    @AfterEach
    public void closeBrowser() {
        closeDriver();
    }
}
