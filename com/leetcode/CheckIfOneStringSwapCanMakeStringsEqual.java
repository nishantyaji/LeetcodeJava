package com.leetcode;

// Problem 1790
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];
        int aInt = 'a';
        for (int i = 0; i < s1.length(); i++) {
            counter1[s1.charAt(i) - aInt]++;
            counter2[s2.charAt(i) - aInt]++;
        }
        for (int i = 0; i < 26; i++) {
            if (counter1[i] != counter2[i])
                return false;
        }

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            if (count > 2)
                return false;
        }
        return true;
    }
}
