package com.leetcode;

// Problem 2166
public class CheckIfParenthesesStringCanBeValid {

    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        int half = n / 2;
        if (2 * half != n) {
            return false;
        }
        int opc = 0, clc = 0, i, j;

        for (i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    opc++;
                } else {
                    clc++;
                }
                if (opc > half || clc > (i + 1) / 2) {
                    return false;
                }
            }
        }

        opc = 0;
        clc = 0;
        for (i = n - 1; i >= 0; i--) {
            j = (n - i) / 2;
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    opc++;
                } else {
                    clc++;
                }
                if (clc > half || opc > j) {
                    return false;
                }
            }
        }
        return true;
    }


}
