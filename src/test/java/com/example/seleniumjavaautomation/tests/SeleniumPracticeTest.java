package com.example.seleniumjavaautomation.tests;

import com.example.seleniumjavaautomation.data.AutomationPracticeData;
import com.example.seleniumjavaautomation.data.SeleniumPracticeData;
import com.example.seleniumjavaautomation.library.Browser;
import com.example.seleniumjavaautomation.library.GlobalMethods;
import com.example.seleniumjavaautomation.pages.AutomationPracticePage;
import com.example.seleniumjavaautomation.pages.SeleniumPracticePage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.PageFactory;

import static io.qameta.allure.Allure.step;

public class SeleniumPracticeTest {

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
            Browser.checkTitle(SeleniumPracticeData.SELENIUM_PRACTICE_TITLE);
        });

        step("Check if the url is correct", () -> {
            Browser.checkUrl(SeleniumPracticeData.SELENIUM_PRACTICE_URL);
        });
    }


}
