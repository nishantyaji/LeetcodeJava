package com.leetcode;

// Problem 2425
public class BitwiseXorOfAllPairings {

    private int xor(int [] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public int xorAllNums(int[] nums1, int[] nums2) {
        int x1 = xor(nums1);
        int x2 = xor(nums2);
        return (nums2.length % 2 == 1 ? x2 : 0) ^ (nums2.length % 2 == 1 ? x1 : 0);
    }

}
