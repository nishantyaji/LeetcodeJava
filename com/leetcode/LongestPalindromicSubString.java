package com.leetcode;

public class LongestPalindromicSubString {

    public static void main(String[] args) {
        LongestPalindromicSubString l = new LongestPalindromicSubString();
        System.out.println(l.longestPalindrome("babad"));
        System.out.println(l.longestPalindrome("cbbd"));
        System.out.println(l.longestPalindrome("a"));
        System.out.println(l.longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String maxPalindrome = "";
        for (int i = 1; i < s.length(); i++) {
            String oddPal = findLongestAtIndex(s, i, true);
            String evenPal = findLongestAtIndex(s, i, false);
            if (oddPal.length() > maxPalindrome.length()) {
                maxPalindrome = oddPal;
            }
            if (evenPal.length() > maxPalindrome.length()) {
                maxPalindrome = evenPal;
            }
        }
        return maxPalindrome;
    }


    private String findLongestAtIndex(String s, int idx, boolean oddLength) {
        int startIdx = idx - 1;
        int endIdx = oddLength ? idx + 1 : idx;
        String palindrome = oddLength ? s.substring(idx, idx + 1) : "";
        while (startIdx >= 0 && endIdx < s.length()) {
            // check odd length palindrome
            if (s.substring(startIdx, startIdx + 1).equals(s.substring(endIdx, endIdx + 1))) {
                palindrome = s.substring(startIdx, startIdx + 1) + palindrome + s.substring(endIdx, endIdx + 1);
            } else {
                break;
            }
            startIdx--;
            endIdx++;
        }
        return palindrome;
    }
}