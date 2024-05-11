package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SplitStringIntoDescendingConsecutiveValues {
    // Time exceeded
    public static void main(String[] args) {
        SplitStringIntoDescendingConsecutiveValues s = new SplitStringIntoDescendingConsecutiveValues();
        s.splitString("0166537080");
        s.splitString("1234");
        s.splitString("050043");
        s.splitString("9080701");
        s.splitString("0090089");
        s.splitString("53520515049");
        s.splitString("534487747151478");
        s.splitString("99999999999999999998");
    }

    public boolean splitString(String s) {
        List<List<String>> universalList = new ArrayList<>();
        boolean result = recurse(universalList, new ArrayList<>(), s, 0);
        if (result) {
            System.out.println(String.join(",", universalList.get(0)));
        }
        return result;
    }

    private boolean recurse(List<List<String>> universalList, List<String> runningList, String s, int start) {
        int n = s.length();
        for (int j = start + 1; j <= n && universalList.isEmpty(); j++) {
            String substr = s.substring(start, j);
            if (conditionMet(runningList, substr)) {
                List<String> runningListCopy = new ArrayList<>(runningList);
                runningListCopy.add(substr);
                if (j == n) {
                    if (runningListCopy.size() > 1) {
                        universalList.add(runningListCopy);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    recurse(universalList, runningListCopy, s, j);
                }
            }
        }
        return !universalList.isEmpty();
    }

    private boolean conditionMet(List<String> numbers, String next) {
        try {
            if (numbers.isEmpty()) {
                return true;
            }
            return Long.parseLong(next) == Long.parseLong(numbers.get(numbers.size() - 1)) - 1;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
