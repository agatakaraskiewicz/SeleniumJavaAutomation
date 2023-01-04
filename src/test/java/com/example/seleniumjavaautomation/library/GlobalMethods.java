package com.example.seleniumjavaautomation.library;

import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.time.ZoneOffset.UTC;

public class GlobalMethods {

    //method generates a random integer in range of minimum and maximum number
    public int randomIntInRange(int min, int max) {
        return (int)Math.floor(Math.random()*(max - min +1) + min);
    }

    //method takes WebElement list, extracts text from each of them to another list and returns it
    public static List<String> makeListOfTextInElements(List<WebElement> webElementsList) {
        List<String> textList = new ArrayList<>();
        for (WebElement element:webElementsList) {
            textList.add(element.getText());
        }
        return textList;
    }

    //method formats current date to look look like: Wed, Jan 04 2023 (it will use English names for days)
    //useful for tests on changing departure date
    public static String currentDateFormatter() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, LLL dd yyyy", Locale.ENGLISH);
        return date.format(formatter);
    }

}
