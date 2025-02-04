package com.leetcode;


// Problem 1800
public class MaxAscendingSubarraySum {

    public int maxAscendingSum(int[] nums) {
        int cumu = 0, prev = -1, res = -1;

        for (int num : nums) {
            res = Math.max(res, cumu);
            cumu = num > prev ? cumu + num : num;
            prev = num;
        }
        return Math.max(res, cumu);
    }
}
