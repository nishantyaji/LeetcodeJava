package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3 {
    public static void main(String[] args) {
        Sum3 s = new Sum3();
        s.display(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        s.display(s.threeSum(new int[]{}));
        s.display(s.threeSum(new int[]{0}));
    }

    public void display(List<List<Integer>> all) {
        for (List<Integer> list : all) {
            list.forEach(i -> System.out.print(i + ","));
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int[] flags = new int[200001];
        int offset = 100000;

        for (int num : nums) {
            flags[offset + num]++;
        }

        Set<List<Integer>> all = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (offset - sum < 0 || offset - sum >= flags.length) {
                    continue;
                }
                int val = flags[offset - sum] - (-sum == nums[i] ? 1 : 0) - (-sum == nums[j] ? 1 : 0);
                if (val >= 1) {
                    List<Integer> local = new ArrayList<>();
                    local.add(nums[i]);
                    local.add(nums[j]);
                    local.add(-sum);
                    Collections.sort(local);
                    all.add(local);
                }
            }
        }
        return new ArrayList<>(all);
    }
}
