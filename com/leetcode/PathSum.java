package com.leetcode;

import java.util.Objects;

public class PathSum {
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

    public static void main(String[] args) {

    }

    private boolean hasPath = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }
        preOrderRecurse(root, 0, targetSum);
        return hasPath;
    }

    private void preOrderRecurse(TreeNode node, int cumulativeSum, int targetSum) {
        if (Objects.isNull(node) || hasPath) {
            return;
        }
        cumulativeSum += node.val;
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            if (cumulativeSum == targetSum) {
                hasPath = true;
            }
            return;
        }
        preOrderRecurse(node.left, cumulativeSum, targetSum);
        preOrderRecurse(node.right, cumulativeSum, targetSum);
    }
}
