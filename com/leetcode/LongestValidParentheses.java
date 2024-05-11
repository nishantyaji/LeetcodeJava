package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.longestValidParentheses("(())("));
        System.out.println(l.longestValidParentheses(")))(())((()))())))"));
        System.out.println(l.longestValidParentheses("(()"));
        System.out.println(l.longestValidParentheses(")()())"));
        System.out.println(l.longestValidParentheses(""));
    }

    public int longestValidParentheses(String s) {
        int maxLength = 0;
        List<Integer> numArray = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            numArray.add(s.substring(i, i + 1).equals("(") ? 1 : -1);
        }
        for (int i = 0; i < numArray.size(); i++) {
            int j = 0;
            int runningSum = 0;
            int runningLength = 0;
            while (i + j < numArray.size() && runningSum + numArray.get(i + j) >= 0) {
                runningSum += numArray.get(i + j);
                j++;
                runningLength++;
                if(runningSum == 0 && runningLength > maxLength) {
                    maxLength = runningLength;
                }
            }
            if (runningSum == 0 && runningLength > maxLength) {
                maxLength = runningLength;
            }
        }
        return maxLength;
    }
}
