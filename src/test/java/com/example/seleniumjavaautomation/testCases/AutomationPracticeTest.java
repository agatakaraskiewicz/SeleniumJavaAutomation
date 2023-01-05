package com.example.seleniumjavaautomation.testCases;

import com.example.seleniumjavaautomation.data.AutomationPracticeData;
import com.example.seleniumjavaautomation.library.Browser;
import com.example.seleniumjavaautomation.library.GlobalMethods;
import com.example.seleniumjavaautomation.pages.AutomationPracticePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import static com.example.seleniumjavaautomation.library.Browser.closeDriver;
import static io.qameta.allure.Allure.step;

public class AutomationPracticeTest {

    private AutomationPracticePage autoPracticePage;
    private GlobalMethods globalMethods;

    @BeforeEach
    public void openBrowserAndCheck() {
        //initialize WebDriver
        Browser.StartBrowser("Chrome", AutomationPracticeData.AUTOMATION_PRACTICE_URL);

        //initialize other used classes
        autoPracticePage = PageFactory.initElements(Browser.getDriver(), AutomationPracticePage.class);
        globalMethods = PageFactory.initElements(Browser.getDriver(), GlobalMethods.class);

        step("Check if the tab has correct name", () -> {
            Browser.checkTitle(AutomationPracticeData.AUTOMATION_PRACTICE_TITLE);
        });

        step("Check if the url is correct", () -> {
            Browser.checkUrl(AutomationPracticeData.AUTOMATION_PRACTICE_URL);
        });
    }

    @Test
    @Tag("alerts")
    @DisplayName("Verify if provided name appears on the Alert pop-up")
    public void alertCheck() {
        step("Provide a name", () -> {
            autoPracticePage.provideName("Agata");
        });

        step("Click on 'Alert' button and verify if there is provided name on it", () -> {
            autoPracticePage.clickAlertButton();
            globalMethods.checkIfAlertContainsText("Agata");
        });

        step("Close the alert pop-up - accept", () -> {
            Browser.getDriver().switchTo().alert().accept();
        });
    }

    @Test
    @Tag("alerts")
    @DisplayName("Verify if there is possibility to not confirm on pop-up")
    public void confirmationCheck() {
        step("Provide a name", () -> {
            autoPracticePage.provideName("Blikle");
        });

        step("Click on 'Confirm' button and verify if there is provided name on it", () -> {
            autoPracticePage.clickConfirmButton();
            globalMethods.checkIfAlertContainsText("Blikle");
        });

        step("Close the alert pop-up - dismiss", () -> {
            Browser.getDriver().switchTo().alert().dismiss();
        });

    }

    @AfterEach
    public void closeBrowser() {
        closeDriver();
    }
}
