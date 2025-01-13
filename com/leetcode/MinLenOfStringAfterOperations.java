package com.leetcode;

// Problem 3223
public class MinLenOfStringAfterOperations {

    public static void main(String[] args) {
        MinLenOfStringAfterOperations m = new MinLenOfStringAfterOperations();
        System.out.println(m.minimumLength("aabccabba"));
    }

    public int minimumLength(String s) {
        int i, res = 0, n = s.length();
        int[] mp = new int[26];
        for (i = 0; i < n; i++) {
            int j = (int) (s.charAt(i)) - (int) 'a';
            mp[j]++;
            if (mp[j] > 2) {
                res = res + (mp[j] % 2 == 1 ? -1 : 1);
            } else {
                res++;
            }
        }
        return res;
    }
}
