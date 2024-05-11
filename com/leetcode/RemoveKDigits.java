package com.leetcode;

public class RemoveKDigits {
    public static void main(String[] args) {
        RemoveKDigits r = new RemoveKDigits();
        System.out.println(r.removeKdigits("1432219", 3));
        System.out.println(r.removeKdigits("10200", 1));
        System.out.println(r.removeKdigits("1010200", 2));
        System.out.println(r.removeKdigits("112200", 3));
        System.out.println(r.removeKdigits("1000", 2));
        System.out.println(r.removeKdigits("0010010", 2));
        System.out.println(r.removeKdigits("10001", 1));
        System.out.println(r.removeKdigits("10001", 4));
        System.out.println(r.removeKdigits("112", 1));
        System.out.println(r.removeKdigits("5337", 2));
    }

    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        int firstZeroIndex = firstIndexOfZero(num);
        while (firstZeroIndex <= k && firstZeroIndex >= 0 && k > 0) {
            num = num.substring(firstZeroIndex + 1);
            k -= firstZeroIndex;
            firstZeroIndex = firstIndexOfZero(num);
        }
        if (k <= 0) {
            return num.length() == 0 ? "0" : trimString(num);
        }

        String runningNum = "";


        int i = 0;
        int prev = Integer.MIN_VALUE;
        for (; i < num.length() && k > 0; i++) {
            String numChar = num.substring(i, i + 1);
            int numVal = Integer.parseInt(numChar);

            if (numVal < prev) {
                k--;
                runningNum = runningNum.substring(0, runningNum.length() - 1);
                prev = runningNum.length() > 0 ? Integer.parseInt(runningNum.substring(runningNum.length() - 1)) : Integer.MIN_VALUE;
                i--;
                continue;
            } else {
                runningNum += Integer.toString(numVal);
            }
            prev = numVal;
        }
        if (k == 0 && i < num.length()) {
            runningNum += num.substring(i);
        } else if (k > 0) {
            runningNum = k > runningNum.length() ? "0" : runningNum.substring(0, runningNum.length() - k);
        }

        return runningNum.length() == 0 ? "0" : trimString(runningNum);
    }

    private int firstIndexOfZero(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.substring(i, i + 1).equals("0")) {
                return i;
            }
        }
        return -1;
    }

    private String trimString(String input) {
        if (input.length() == 0) {
            return "0";
        }
        while (input.substring(0, 1).equals("0")) {
            if (input.length() > 1) {
                input = input.substring(1);
            } else {
                return input;
            }
        }
        return input;
    }
}
