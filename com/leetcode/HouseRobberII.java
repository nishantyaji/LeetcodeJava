package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberII {
    public static void main(String[] args) {
        HouseRobberII h = new HouseRobberII();
        System.out.println(h.rob(new int[]{2, 3, 2})); //3
        System.out.println(h.rob(new int[]{1, 2, 3, 1})); //4
        System.out.println(h.rob(new int[]{1, 2, 3})); //3
    }

    public int rob(int[] nums) {
        Map<Integer, Integer> mapFromZeroOnwards = new HashMap<>();
        int dpZeroToMinusTwo = robdp(nums, nums.length - 3, mapFromZeroOnwards);
        int dpZeroToMinusOne = robdp(nums, nums.length - 2, mapFromZeroOnwards);
        Map<Integer, Integer> mapFromOneOnwards = new HashMap<>();
        int[] newNums = new int[nums.length - 1];
        if (newNums.length >= 0) {
            System.arraycopy(nums, 1, newNums, 0, newNums.length);
        }
        int dpOnetoMinusTwo = robdp(newNums, newNums.length - 3, mapFromOneOnwards);

        if (dpZeroToMinusTwo > dpOnetoMinusTwo) {
            //first one is chosen in dpZeroToMinusTwo
            // Max(dpZeroToMinusTwo, dpOneToMinusTwo + nums[nums.length-1], dpZeroToMinusOne
            return Math.max(Math.max(dpZeroToMinusTwo, dpOnetoMinusTwo + nums[nums.length - 1]), dpZeroToMinusOne);
        } else {
            return Math.max(dpOnetoMinusTwo + nums[nums.length - 1], dpZeroToMinusOne);
        }
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
