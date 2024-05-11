package com.leetcode;

import java.util.Stack;

public class ReverserWordInAString {
    public static void main(String[] args) {
        ReverserWordInAString r = new ReverserWordInAString();
        String input = "the sky is blue";
        String output = "blue is sky the";
        System.out.println(output.equals(r.reverseWords(input)));

        input = "  hello world  ";
        output = "world hello";
        System.out.println(output.equals(r.reverseWords(input)));

        input = "a good   example";
        output = "example good a";
        System.out.println(output.equals(r.reverseWords(input)));

        input = "  Bob    Loves  Alice   ";
        output = "Alice Loves Bob";
        System.out.println(output.equals(r.reverseWords(input)));

        input = "Alice does not even like bob";
        output = "bob like even not does Alice";
        System.out.println(output.equals(r.reverseWords(input)));
    }

    public String reverseWords(String s) {
        Stack<String> reverse = new Stack<>();
        String space = " ";
        String runningString = "";
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(i, i + 1);
            if (subStr.equals(space)) {
                if (runningString.length() > 0) {
                    reverse.push(runningString);
                    runningString = "";
                }
            } else {
                runningString = runningString + subStr;
            }
        }
        if (runningString.length() > 0) {
            reverse.push(runningString);
        }
        String returnString = "";
        if (!reverse.isEmpty()) {
            while (reverse.size() > 1) {
                returnString += reverse.pop() + space;
            }
            returnString += reverse.pop();
        }
        return returnString;
    }
}
