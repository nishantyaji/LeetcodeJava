package com.leetcode;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(t.trap(new int[]{4, 2, 0, 3, 2, 5})); // 9
    }

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int sumOfArea = 0;
        int[] maxLeftArray = new int[height.length];
        int[] maxRightArray = new int[height.length];
        int maxLeft = -1;
        int maxRight = -1;
        for (int i = 0; i < height.length; i++) {
            int j = height.length - 1 - i;
            if (height[i] > maxLeft) {
                maxLeft = height[i];
            }
            if (height[j] > maxRight) {
                maxRight = height[j];
            }
            maxLeftArray[i] = maxLeft;
            maxRightArray[j] = maxRight;
        }
        for (int i = 0; i < height.length; i++) {
            int base = maxLeftArray[i] < maxRightArray[i] ? maxLeftArray[i] : maxRightArray[i];
            sumOfArea += (base - height[i]);
        }
        return sumOfArea;
    }

}