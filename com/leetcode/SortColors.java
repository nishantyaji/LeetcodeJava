package com.leetcode;

// Solution to the leet code problem 75
public class SortColors {

    public static void main(String[] args) {
        SortColors s = new SortColors();
        int [] nums = {2,0,2,1,1,0};
        s.sortColors(nums);
    }

    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]] + 1;
        }

        int j = 0;
        for(int i = 0; i <= 2; i++) {
            while(count[i] > 0) {
                nums[j++] = i;
                count[i]--;
            }
        }
    }
}
