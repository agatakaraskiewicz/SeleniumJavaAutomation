package com.example.seleniumjavaautomation.testCases;

import com.example.seleniumjavaautomation.data.AutomationPracticeData;
import com.example.seleniumjavaautomation.library.Browser;
import com.example.seleniumjavaautomation.pages.AutomationPracticePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import static com.example.seleniumjavaautomation.library.Browser.closeDriver;
import static io.qameta.allure.Allure.step;

public class AutomationPracticeTest {

    private AutomationPracticePage autoPracticePage;

    @BeforeEach
    public void openBrowserAndCheck() {
        //initialize WebDriver
        Browser.StartBrowser("Chrome", AutomationPracticeData.AUTOMATION_PRACTICE_URL);

        //initialize other used classes
        autoPracticePage = PageFactory.initElements(Browser.getDriver(), AutomationPracticePage.class);

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

    }

    @AfterEach
    public void closeBrowser() {
        closeDriver();
    }
}
