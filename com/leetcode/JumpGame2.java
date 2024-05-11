package com.leetcode;

public class JumpGame2 {
    public static void main(String[] args) {
        JumpGame2 j = new JumpGame2();
        System.out.println(j.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(j.jump(new int[]{2, 3, 0, 1, 4}));
    }

    public int jump(int[] nums) {
        int [] distance = new int [nums.length];
        for(int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;

        for(int idx = 0; idx < nums.length; idx++) {
            for(int j = 1; j <= nums[idx] && j + idx < nums.length; j++) {
                if(distance[idx] + 1 < distance[idx+j]) {
                    distance[idx+j] = distance[idx] + 1;
                }
            }
        }

        return distance[distance.length-1];
    }
}
