package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToEnglishWords {

    private Map<Integer, String> tens = new HashMap<>();
    private Map<Integer, String> ones = new HashMap<>();

    private static final String THOUSAND = "Thousand";
    private static final String MILLION = "Million";
    private static final String BILLION = "Billion";
    private static final String HUNDRED = "Hundred";

    private static final String SPACE = " ";

    private IntegerToEnglishWords() {
        ones.put(1, "One");
        ones.put(2, "Two");
        ones.put(3, "Three");
        ones.put(4, "Four");
        ones.put(5, "Five");
        ones.put(6, "Six");
        ones.put(7, "Seven");
        ones.put(8, "Eight");
        ones.put(9, "Nine");
        ones.put(10, "Ten");
        ones.put(11, "Eleven");
        ones.put(12, "Twelve");
        ones.put(13, "Thirteen");
        ones.put(14, "Fourteen");
        ones.put(15, "Fifteen");
        ones.put(16, "Sixteen");
        ones.put(17, "Seventeen");
        ones.put(18, "Eighteen");
        ones.put(19, "Nineteen");

        tens.put(2, "Twenty");
        tens.put(3, "Thirty");
        tens.put(4, "Forty");
        tens.put(5, "Fifty");
        tens.put(6, "Sixty");
        tens.put(7, "Seventy");
        tens.put(8, "Eighty");
        tens.put(9, "Ninety");
    }

    public static void main(String[] args) {
        IntegerToEnglishWords i = new IntegerToEnglishWords();
        System.out.println(i.numberToWords(100));
        System.out.println(i.numberToWords(123));
        System.out.println(i.numberToWords(12345));
        System.out.println(i.numberToWords(1234567));
    }

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        List<String> tokens = new ArrayList<>();
        int billions = num / 1000000000;
        if (billions > 0) {
            String billion = getStringForThreePlaces(billions);
            tokens.add(billion);
            tokens.add(BILLION);
        }
        num = num % 1000000000;
        int millions = num / 1000000;
        if (millions > 0) {
            String million = getStringForThreePlaces(millions);
            tokens.add(million);
            tokens.add(MILLION);
        }
        num = num % 1000000;
        int thousands = num / 1000;
        if (thousands > 0) {
            String thousand = getStringForThreePlaces(thousands);
            tokens.add(thousand);
            tokens.add(THOUSAND);
        }
        num = num % 1000;
        if (num > 0) {
            String numString = getStringForThreePlaces(num);
            tokens.add(numString);
        }
        return String.join(SPACE, tokens);
    }

    private String getStringForThreePlaces(int num) {
        List<String> tokens = new ArrayList<>();
        num = num % 1000;
        int hundred = num / 100;
        if (hundred > 0) {
            tokens.add(ones.get(hundred));
            tokens.add(HUNDRED);
        }
        int rem = num % 100;
        if (rem < 20 && rem > 0) {
            tokens.add(ones.get(rem));
        } else {
            int tensR = rem / 10;
            if (tensR > 1) {
                tokens.add(tens.get(tensR));
            }
            int units = rem % 10;
            if (units > 0) {
                tokens.add(ones.get(units));
            }
        }
        return String.join(" ", tokens);
    }
}
