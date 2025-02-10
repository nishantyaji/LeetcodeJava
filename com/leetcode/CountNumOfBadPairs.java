package com.leetcode;

import java.util.HashMap;
import java.util.Map;

// Problem 2364
public class CountNumOfBadPairs {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
        }
        for (int v : map.values()) {
            res += (long) (nums.length - v) * v;
        }
        return res / 2;
    }
}
