package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindModeInBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maxCount = Integer.MIN_VALUE;
    private Map<Integer, Integer> map = new HashMap<>();

    private void addToMap(int val) {
        int count = 1;
        if(map.containsKey(val)) {
            count = map.get(val);
            count++;
        }
        if(count > maxCount) {
            maxCount = count;
        }
        map.put(val, count);
    }

    public int[] findMode(TreeNode root) {
        inOrder(root);
        return map.entrySet().stream().filter(entry -> entry.getValue() == maxCount).map(Map.Entry::getKey).collect(Collectors.toList()).stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrder(TreeNode root) {
        if(Objects.isNull(root)) {
            return;
        }
        if(Objects.nonNull(root.left)) {
            inOrder(root.left);
        }
        addToMap(root.val);
        if(Objects.nonNull(root.right)) {
            inOrder(root.right);
        }
    }
}
