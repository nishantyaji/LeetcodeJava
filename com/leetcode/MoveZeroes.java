package com.leetcode;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        m.moveZeroes(new int [] {0,1,0,3,12});
        m.moveZeroes(new int [] {0});
        m.moveZeroes(new int [] {0, 0, 1});
    }

    public void moveZeroes(int[] nums) {
        int removedAmount = 0;
        for(int i = 0; i < nums.length - removedAmount; i++) {
            if(nums[i] == 0) {
                int iCopy = i;
                for(int j = i+1; j < nums.length - removedAmount; j++) {
                    nums[iCopy++] = nums[j];
                }
                removedAmount++;
                nums[nums.length - removedAmount] = 0;
            }
        }
    }
}
