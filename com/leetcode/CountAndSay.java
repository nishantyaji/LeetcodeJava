package com.leetcode;

public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();
        System.out.println(c.countAndSay(5));
    }

    public String countAndSay(int n) {
        String input = "1";
        for (int i = 1; i < n; i++) {
            input = convert(input);
        }
        return input;
    }

    private String convert(String input) {
        String result = "";
        String base = input.substring(0, 1);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.substring(i, i + 1).equals(base)) {
                count++;
            } else {
                result += count + base;
                base = input.substring(i, i + 1);
                count = 1;
            }
        }
        return result + count + base;
    }
}
