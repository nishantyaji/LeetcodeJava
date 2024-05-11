package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum problem = new TwoSum();
        int[] result = problem.twoSum(new int[]{3, 2, 4}, 6);
        for (int r : result) {
            System.out.print(r + ", ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> upperHalf = new HashMap<>();
        List<Integer> midIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (target % 2 == 0 && nums[i] == target / 2) {
                midIndices.add(i);
            } else if (nums[i] > target / 2 && nums[i] < target) {
                upperHalf.put(nums[i], i);
            }
        }
        if (midIndices.size() > 1) {
            return new int[]{midIndices.get(0), midIndices.get(1)};
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target / 2 && upperHalf.containsKey(target - nums[i])) {
                return new int[]{i, upperHalf.get(target - nums[i])};
            }
        }
        return new int[]{-1, -1};
    }
}
