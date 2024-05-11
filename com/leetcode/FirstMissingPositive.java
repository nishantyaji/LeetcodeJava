package com.leetcode;

public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        System.out.println(f.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(f.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(f.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    public int firstMissingPositive(int[] nums) {
        boolean[] exists = new boolean[nums.length];
        for (int num : nums) {
            if (num < 1 || num > nums.length) {
                continue;
            }
            exists[num - 1] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!exists[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
