package com.leetcode;

import java.util.*;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("()"));
        System.out.println(validParenthesis.isValid("()[]{}"));
        System.out.println(validParenthesis.isValid("(]"));
        System.out.println(validParenthesis.isValid("([)]"));
        System.out.println(validParenthesis.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        List<String> opens = Arrays.asList("(", "{", "[");
        List<String> closes = Arrays.asList(")", "}", "]");
        Map<String, String> closeToOpenMap = new HashMap<>();
        closeToOpenMap.put(")", "(");
        closeToOpenMap.put("}", "{");
        closeToOpenMap.put("]", "[");
        Stack<String> myStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (opens.contains(sub)) {
                myStack.push(sub);
            } else {
                if (myStack.size() == 0) {
                    return false;
                }
                String popped = myStack.pop();
                if (!closeToOpenMap.get(sub).equals(popped)) {
                    return false;
                }
            }
        }
        return myStack.size() == 0;
    }
}
