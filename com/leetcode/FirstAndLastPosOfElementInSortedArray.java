package com.leetcode;

import java.util.Arrays;

public class FirstAndLastPosOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int finalStart = -1, finalEnd = -1;
        int start = 0, end = nums.length - 1, mid;
        int found = -1;
        while (nums.length > 0 && target >= nums[start] && target <= nums[end]) {
            if (target == nums[start]) {
                found = start;
            } else if (target == nums[end]) {
                found = end;
            }
            if (end == start + 1 && found < 0 || found > -1) {
                break;
            }

            mid = (start + end) / 2;
            if (nums[mid] == target) {
                found = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (found > -1) {
            start = end = found;
            for (int i = -1; i + found >= 0; i--) {
                if (nums[i + found] == target) {
                    start--;
                }
            }
            for (int i = 1; i + found < nums.length; i++) {
                if (nums[i + found] == target) {
                    end++;
                }
            }
            finalStart = start;
            finalEnd = end;
        }
        return new int[]{finalStart, finalEnd};
    }

    public static void main(String[] args) {
        FirstAndLastPosOfElementInSortedArray f = new FirstAndLastPosOfElementInSortedArray();
        Arrays.stream(f.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(f.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(f.searchRange(new int[]{}, 0)).forEach(System.out::print);
        System.out.println();
    }
}
