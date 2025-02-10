package com.leetcode;

import java.util.Stack;

// Problem 3174
public class ClearDigits {

    public String clearDigits(String s) {
        Stack<String> stack = new Stack<>();
        String digits = "0123456789";
        for (int i = 0; i < s.length(); i++) {
            if (digits.contains(s.substring(i, i + 1))) {
                stack.pop();
            } else {
                stack.push(s.substring(i, i + 1));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String str : stack) {
            builder.append(str);
        }
        return builder.toString();
    }
}
