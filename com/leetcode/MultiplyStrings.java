package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        System.out.println(m.multiply("0", "213"));
        m.calculateTable("12").forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println(m.add2Strings("99", "198"));
        System.out.println();
        System.out.println(m.multiply("99", "99"));
        System.out.println(m.multiply("9456479", "99456")); //940503575424
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String base, other;
        if (num1.length() == num2.length()) {
            base = num1;
            other = num2;
        } else {
            base = num1.length() < num2.length() ? num1 : num2;
            other = num1.length() > num2.length() ? num1 : num2;
        }

        Map<String, String> table = calculateTable(base);
        String result = "0";
        for (int i = other.length() - 1; i >= 0; i--) {
            String toAdd = table.get(other.substring(i, i + 1));
            String pad = zeroPadding(other.length() - 1 - i);
            toAdd = toAdd + pad;
            result = add2Strings(result, toAdd);
        }

        return result;
    }

    private Map<String, String> calculateTable(String num) {
        Map<String, String> table = new HashMap<>();
        table.put("0", "0");
        table.put("1", num);
        for (int i = 2; i <= 9; i++) {
            int carry = 0;
            String result = "";
            for (int d = num.length() - 1; d >= 0; d--) {
                int digit = Integer.parseInt(num.substring(d, d + 1));
                int thisRes = digit * i + carry;
                int rem = thisRes % 10;
                carry = thisRes / 10;
                result = rem + result;
            }
            if (carry > 0) {
                result = carry + result;
            }
            table.put(Integer.toString(i), result);
        }
        return table;
    }

    private String add2Strings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            String pad = zeroPadding(Math.abs(s1.length() - s2.length()));
            if (s1.length() > s2.length()) {
                s2 = pad + s2;
            } else {
                s1 = pad + s1;
            }
        }
        int carry = 0;
        String result = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            int val = Integer.parseInt(s1.substring(i, i + 1)) + Integer.parseInt(s2.substring(i, i + 1)) + carry;
            int rem = val % 10;
            carry = val / 10;
            result = rem + result;
        }
        if (carry > 0) {
            result = carry + result;
        }
        return result;
    }

    private String zeroPadding(int num) {
        String result = "";
        for (int i = 0; i < num; i++) {
            result += "0";
        }
        return result;
    }
}
