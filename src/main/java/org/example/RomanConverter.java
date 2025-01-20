package org.example;

public class RomanConverter implements RomanConverterInterface{

    @Override
    public int romanToDecimal(String roman) {
        int totalValue = 0;
        int prevValue = 0;

        for(int i = roman.length() - 1; i >= 0; i--) {

            char currentChar = roman.charAt(i);
            int currentValue = RomanMapping.ROMAN_TO_DECIMAL.get(currentChar);

            if (currentValue >= prevValue) {
                totalValue += currentValue;
            } else if (currentValue < prevValue) {
                totalValue -= currentValue;
            }
            prevValue = currentValue;
        }
        return totalValue;
    }

    @Override
    public String decimalToRoman(int decimal) {

        if (decimal <= 0 || decimal > 3999) {
            throw new IllegalArgumentException("Decimal invalido");
        }else {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romanValues = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder roman = new StringBuilder();

            for(int i = 0; i < values.length; i++){
                while (values[i] <= decimal) {
                    roman.append(romanValues[i]);
                    decimal -= values[i];
                }
            }
            return roman.toString();
        }

    }
}
