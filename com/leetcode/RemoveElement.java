package com.leetcode;

public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        System.out.println(r.removeElement(new int []{3,2,2,3}, 3));
        System.out.println(r.removeElement(new int []{0,1,2,2,3,0,4,2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int reducedAmount = 0;
        for(int i = 0; i < nums.length - reducedAmount; i++) {
            if(nums[i] == val) {
                int iCopy = i;
                for(int j = i+1 ; j < nums.length - reducedAmount; j++) {
                    nums[iCopy++] = nums[j];
                }
                reducedAmount++;
                i--;
            }
        }
        return nums.length - reducedAmount;
    }
}
