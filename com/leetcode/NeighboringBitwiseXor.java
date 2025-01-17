package com.leetcode;


// Problem 2683
public class NeighboringBitwiseXor {
    private int xor(int [] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public boolean doesValidArrayExist(int[] derived) {
        return xor(derived) == 0;
    }
}
