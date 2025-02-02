package com.leetcode;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int first = 0, i, j, numsSize = nums.length;

        for (i = 0; i < numsSize; i++) {
            if (nums[(i - 1 + numsSize) % numsSize] > nums[i]) {
                first = i;
                break;
            }
        }

        int[] arr = new int[2 * numsSize];
        for (i = 0; i < 2; i++) {
            for (j = 0; j < numsSize; j++) {
                arr[numsSize * i + j] = nums[j];
            }
        }

        for (i = first; i < first + numsSize - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
