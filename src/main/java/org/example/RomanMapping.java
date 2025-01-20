package org.example;

import java.util.HashMap;
import java.util.Map;

public class RomanMapping {

    public static final Map<Character, Integer> ROMAN_TO_DECIMAL = new HashMap<>();
    static {
        ROMAN_TO_DECIMAL.put('I', 1);
        ROMAN_TO_DECIMAL.put('V', 5);
        ROMAN_TO_DECIMAL.put('X', 10);
        ROMAN_TO_DECIMAL.put('L', 50);
        ROMAN_TO_DECIMAL.put('C', 100);
        ROMAN_TO_DECIMAL.put('D', 500);
        ROMAN_TO_DECIMAL.put('M', 1000);
    }
}
