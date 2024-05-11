package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(-121));
        System.out.println(p.isPalindrome(121));
        System.out.println(p.isPalindrome(10));
        System.out.println(p.isPalindrome(0));
    }

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        if(x < 10) {
            return true;
        }
        List<Integer> digits = new ArrayList<>();
        int temp = x;
        while(temp > 0) {
            int rem = temp % 10;
            temp = temp / 10;
            digits.add(rem);
        }
        int max = (digits.size() - 1)/2;
        for(int i = 0; i <= max; i++) {
            int reflection = digits.size()-1-i;
            if(!digits.get(i).equals(digits.get(reflection))) {
                return false;
            }
        }
        return true;
    }
}
