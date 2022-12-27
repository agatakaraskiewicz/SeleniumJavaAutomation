package com.example.seleniumjavaautomation.library;

import java.util.concurrent.ThreadLocalRandom;

public class GlobalMethods {

    //randomIntInRange returns a random integer in range from min to max (included)
    public int randomIntInRange(int min, int max) {
        return (int)Math.floor(Math.random()*(max - min +1) + min);
    }

}
