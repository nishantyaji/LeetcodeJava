package com.leetcode;

public class MaxProductDiffBw2Pairs {

    public static void main(String[] args) {
        MaxProductDiffBw2Pairs m = new MaxProductDiffBw2Pairs();
        System.out.println(m.maxProductDifference(new int[]{5, 6, 2, 7, 4})); //34
        System.out.println(m.maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8})); //64
        System.out.println(m.maxProductDifference(new int[]{1, 6, 7, 5, 2, 4, 10, 6, 4})); //68
    }

    public int maxProductDifference(int[] nums) {
        int small = nums[0] < nums[1] ? nums[0] : nums[1];
        int large = nums[0] < nums[1] ? nums[1] : nums[0];
        int min = small;
        int minPlus = large;
        int max = large;
        int maxMinus = small;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < minPlus) {
                int minTemp = nums[i] < min ? nums[i] : min;
                minPlus = nums[i] < min ? min : nums[i];
                min = minTemp;
            }
            if (nums[i] > maxMinus) {
                int maxTemp = nums[i] > max ? nums[i] : max;
                maxMinus = nums[i] > max ? max : nums[i];
                max = maxTemp;
            }
        }
        return (max * maxMinus) - (min * minPlus);
    }
}
