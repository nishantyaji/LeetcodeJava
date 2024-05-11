package com.leetcode;

public class NextPermutation {
    public static void main(String[] args) {
        int [] input = new int[] {1, 2, 3};
        nextPermutation(input);
        displayArray(input);
        input = new int[] {1, 3, 2};
        nextPermutation(input);
        displayArray(input);
    }
    public static void displayArray(int [] input) {
        for(int i : input) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        boolean swapped = false;
        for(int i = nums.length-2; i >= 0 && !swapped; i--) {
            for(int j = nums.length-1; j > i; j--) {
                if(nums[i] < nums[j]) {
                    int swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                    for(int k = i+1; k < nums.length-1; k++) {
                        for(int l = k+1; l < nums.length; l++) {
                            if(nums[k] > nums[l]) {
                                swap = nums[k];
                                nums[k] = nums[l];
                                nums[l] = swap;
                            }
                        }
                    }
                    swapped = true;
                    break;
                }
            }
        }
        if(!swapped) {
            for(int i = 0; i <= (nums.length-1)/2; i++) {
                int swap = nums[i];
                nums[i] = nums[nums.length - i -1];
                nums[nums.length - i - 1] = swap;
            }
        }
    }
}
