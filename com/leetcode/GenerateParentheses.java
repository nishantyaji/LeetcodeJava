package com.leetcode;

import java.util.*;

public class GenerateParentheses {
    private Map<Integer, Set<String>> numToPatterns = new HashMap<>();

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(2));
        System.out.println(g.generateParenthesis(3));
        System.out.println(g.generateParenthesis(4));
        System.out.println(g.generateParenthesis(4).size());
        System.out.println(g.generateParenthesis(5).size());
        System.out.println(g.generateParenthesis(6).size());
        System.out.println(g.generateParenthesis(7).size());
        System.out.println(g.generateParenthesis(8).size());
    }

    public List<String> generateParenthesis(int n) {
        Set<String> answer = getValFor(n);
        return new ArrayList<>(answer);
    }

    private Set<String> getValFor(int n) {
        if (n == 1) {
            return Collections.singleton("()");
        }
        Set<String> result = new HashSet<>();
        Set<String> prevSet = getValFor(n - 1);
        for (String prevOne : prevSet) {
            result.addAll(addOnePair(prevOne));
        }
        return result;
    }

    private Set<String> addOnePair(String input) {
        int open = 0;
        int close = 0;
        Set<String> result = new HashSet<>();
        result.add("()" + input);
        result.add(input + "()");
        for (int i = 1; i < input.length(); i++) {
            String prefix = input.substring(0, i) + "(";
            if (input.substring(i - 1, i).equals("(")) {
                open++;
            } else {
                close++;
            }
            for (int j = i; j < input.length(); j++) {
                if (open >= close) {
                    result.add(prefix + input.substring(i, j) + ")" + input.substring(j));
                }
            }
        }
        return result;
    }
}
