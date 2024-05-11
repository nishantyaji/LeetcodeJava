package com.leetcode;

public class FindPivotIndex {

    public static void main(String[] args) {
        FindPivotIndex f = new FindPivotIndex();
        System.out.println(f.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(f.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(f.pivotIndex(new int[]{2, 1, -1}));
    }

    public int pivotIndex(int[] nums) {
        int[] cumulativeSum = new int[nums.length];
        int[] cumulativeSumReverse = new int[nums.length];

        int runningSum = 0;
        int reverseRunningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            reverseRunningSum += nums[nums.length - 1 - i];
            cumulativeSum[i] = runningSum;
            cumulativeSumReverse[nums.length - 1 - i] = reverseRunningSum;
        }
        for (int i = 0; i < nums.length; i++) {
            int leftSum = i == 0 ? 0 : cumulativeSum[i-1];
            int rightSum = i == nums.length -1 ? 0: cumulativeSumReverse[i+1];
            if(leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
