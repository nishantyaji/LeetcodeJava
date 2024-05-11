package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return list;
    }

    public void inOrder(TreeNode root) {
        if(Objects.isNull(root)) {
            return;
        }
        if(Objects.nonNull(root.left)){
            inOrder(root.left);
        }
        list.add(root.val);
        if(Objects.nonNull(root.right)){
            inOrder(root.right);
        }
    }

    public static class DeleteAndEarn {

        public static void main(String[] args) {
            DeleteAndEarn d = new DeleteAndEarn();
            System.out.println(d.deleteAndEarn(new int[]{3, 1}));
            System.out.println(d.deleteAndEarn(new int[]{3, 4, 2}));
            System.out.println(d.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        }

        public int deleteAndEarn(int[] nums) {
            Arrays.sort(nums);
            Map<Integer, Integer> counter = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                add(counter, nums[i]);
                if ( i == nums.length - 1 || nums[i + 1] > nums[i] + 1) {
                    sum += rewardify(counter);
                    counter = new HashMap<>();
                }
            }
            sum += rewardify(counter);
            return sum;
        }

        public void add(Map<Integer, Integer> counter, int num) {
            if (counter.containsKey(num)) {
                int val = counter.get(num);
                counter.put(num, val + 1);
            } else {
                counter.put(num, 1);
            }
        }

        public int rewardify(Map<Integer, Integer> counter) {
            List<Integer> vals = counter.entrySet().stream().map(entry -> entry.getValue() * entry.getKey()).collect(Collectors.toList());
            return getMaxSumWithoutConsecutive(vals, 0);
        }

        public int getMaxSumWithoutConsecutive(List<Integer> vals, int sumTillNow) {
            int max = sumTillNow;
            if (vals.size() == 1) {
                return sumTillNow + vals.get(0);
            }
            if (vals.size() == 2) {
                int maxBetweenTwo = vals.get(0) > vals.get(1) ? vals.get(0) : vals.get(1);
                return sumTillNow + maxBetweenTwo;
            }
            for (int i = 0; i < vals.size(); i++) {
                if (i + 2 > vals.size()) {
                    break;
                }
                int tempSum = getMaxSumWithoutConsecutive(vals.subList(i + 2, vals.size()), sumTillNow + vals.get(i));
                if (tempSum > max) {
                    max = tempSum;
                }
            }
            return max;
        }
    }
}
