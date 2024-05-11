package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        System.out.println(h.rob(new int[]{1, 2, 3, 1})); //4
        System.out.println(h.rob(new int[]{2, 7, 9, 3, 1})); //12
        System.out.println(h.rob(new int[]{2, 3, 2})); //4
        System.out.println(h.rob(new int[]{1, 2, 3, 1})); //4
        System.out.println(h.rob(new int[]{1, 2, 3})); //4
    }

    public int rob(int[] nums) {
        return robdp(nums, nums.length - 1, new HashMap<>());
    }

    private int robdp(int[] nums, int n, Map<Integer, Integer> map) {
        if (n < 0) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int minusTwo = robdp(nums, n - 2, map);
        int minusOne = robdp(nums, n - 1, map);
        int val = Math.max(minusOne, minusTwo + nums[n]);
        map.put(n, val);
        return val;
    }
}
