package com.leetcode;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(s.subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int counter = 0;
        int[] cumulativeSum = new int[nums.length];
        int runningCumulative = 0;
        for (int i = 0; i < nums.length; i++) {
            runningCumulative += nums[i];
            cumulativeSum[i] = runningCumulative;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = -1; j < i; j++) {
                int diff = cumulativeSum[i] - (j == -1 ? 0 : cumulativeSum[j]);
                if (diff == k) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
