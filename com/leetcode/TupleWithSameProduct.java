package com.leetcode;


import java.util.HashMap;
import java.util.Map;

// Problem 1726
public class TupleWithSameProduct {

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int prod = nums[i] * nums[j];
                map.putIfAbsent(prod, 0);
                map.put(prod, map.get(prod) + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int temp = entry.getValue();
            if (temp > 1) {
                res += (4 * temp * (temp - 1));
            }
        }
        return res;
    }
}
