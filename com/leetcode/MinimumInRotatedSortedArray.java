package com.leetcode;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        MinimumInRotatedSortedArray m = new MinimumInRotatedSortedArray();
        System.out.println(m.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(m.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(m.findMin(new int[]{11, 13, 15, 17}));
    }

    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int right = nums.length - 1;
        int left = 0;
        int mid;

        while (Math.abs(left - right) > 1) {
            mid = (left + right) / 2;

            if (nums[mid] < nums[left]) {
                right = mid;
            } else if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                return nums[mid];
            }
        }
        if (Math.abs(left - right) == 1) {
            return nums[left] > nums[right] ? nums[right] : nums[left];
        } else {
            return nums[left];
        }
    }
}
