package com.example.seleniumjavaautomation.library;

public class GlobalMethods {
    public int randomIntInRange(int min, int max) {
        return (int)Math.floor(Math.random()*(max - min +1) + min);
    }

}
