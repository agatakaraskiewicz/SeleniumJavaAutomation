package com.example.seleniumjavaautomation.library;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

}
