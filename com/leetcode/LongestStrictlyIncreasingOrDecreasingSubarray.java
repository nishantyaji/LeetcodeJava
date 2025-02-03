package com.leetcode;

import static java.lang.Math.abs;

// Problem 3105
public class LongestStrictlyIncreasingOrDecreasingSubarray {

    public int longestMonotonicSubarray(int[] nums) {
        int prev = nums[0], cumu = 1, res = -1, i = 0;

        for(i = 0; i < nums.length; i++) {
            res = Math.max(abs(cumu), res);
            if(nums[i] > prev) {
                cumu = cumu <= 0 ? 2 : cumu + 1;
            } else if (nums[i] < prev) {
                cumu = cumu >= 0 ? -2 : cumu -1;
            } else {
                cumu = 0;
            }
            prev = nums[i];
        }
        return Math.max(abs(cumu), res);
    }
}
