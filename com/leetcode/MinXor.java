package com.leetcode;

import java.util.ArrayList;
import java.util.List;


// Problem 2429
public class MinXor {
    int count1bits(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) > 0) count++;
            num >>= 1;
        }
        return count;
    }


    public int minimizeXor(int num1, int num2) {
        int len1 = 1 + (int) (Math.log(num1) / Math.log(2));
        int base = (int) Math.pow(2, len1 - 1);
        int newBase = (int) Math.pow(2, len1);
        int ones = count1bits(num2);

        List<Integer> stack = new ArrayList<>();
        int i = 0, ans = 0, idx = 0;

        while (i < ones && base >= 1) {
            if ((base & num1) > 0) {
                ans = ans | base;
                i++;
            } else {
                stack.add(base);
                idx++;
            }
            base >>= 1;
        }

        while (i < ones) {
            if (idx > 0) {
                ans |= stack.get(idx - 1);
                idx--;
            } else {
                ans = ans | newBase;
                newBase <<= 1;
            }
            i++;
        }
        return ans;
    }
}
