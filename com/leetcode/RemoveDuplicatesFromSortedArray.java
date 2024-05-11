package com.leetcode;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        System.out.println(r.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(r.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(r.removeDuplicates(new int[]{}));
        System.out.println(r.removeDuplicates(new int[]{0}));
        System.out.println(r.removeDuplicates(new int[]{0, 0}));
        System.out.println(r.removeDuplicates(new int[]{0, 1}));

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int reductionAmount = 0;

        for (int i = 0; i < nums.length - reductionAmount; i++) {
            int minRepeat = Integer.MAX_VALUE;
            int faux_i = i;
            int numPresentOccurrences = 0;
            while (faux_i + 1 < nums.length -reductionAmount && nums[faux_i] == nums[faux_i + 1]) {
                if (faux_i + 1 < minRepeat) {
                    minRepeat = faux_i + 1;
                }
                faux_i++;
                numPresentOccurrences++;
            }
            if (minRepeat < Integer.MAX_VALUE) {
                for (int j = minRepeat; j + numPresentOccurrences < nums.length - reductionAmount; j++) {
                    nums[j] = nums[j + numPresentOccurrences];
                }
            }
            reductionAmount += numPresentOccurrences;
        }
        return nums.length - reductionAmount;
    }
}
