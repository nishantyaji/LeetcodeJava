package com.leetcode;

public class CountNumHomogenousSubstrings {

    public static void main(String[] args) {
        CountNumHomogenousSubstrings c = new CountNumHomogenousSubstrings();
        System.out.println(c.countHomogenous("abbcccaa"));
        System.out.println(c.countHomogenous("xy"));
        System.out.println(c.countHomogenous("zzzzz"));
    }

    public int countHomogenous(String s) {
        int base = 1000000000 + 7;
        String prev = s.substring(0, 1);
        int totalCount = 0;
        int runningCount = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals(prev)) {
                runningCount++;
            } else {
                totalCount += nC2(runningCount + 1);
                runningCount = 1;
                prev = s.substring(i, i + 1);
            }
        }
        totalCount += nC2(runningCount + 1);
        return totalCount % base;
    }

    public long nC2(long n) {
        int base = 1000000000 + 7;
        return ((n * (n - 1)) / 2) % base;
    }
}
