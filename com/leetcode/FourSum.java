package com.leetcode;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> resultUnit = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(resultUnit);
                            result.add(resultUnit);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public int[] sorted(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] > input[j]) {
                    int swap = input[i];
                    input[i] = input[j];
                    input[j] = swap;
                }
            }
        }
        return input;
    }
}
