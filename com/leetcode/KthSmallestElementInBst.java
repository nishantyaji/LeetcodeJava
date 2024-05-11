package com.leetcode;

import java.util.Objects;

public class KthSmallestElementInBst {
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
    private int inOrderCounter = 0;
    private int value = 0;

    public static void main(String[] args) {
        KthSmallestElementInBst k = new KthSmallestElementInBst();
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return value;
    }

    public void inOrder(TreeNode root, int k) {
        if(inOrderCounter > k) {
            return;
        }

        if(Objects.nonNull(root.left)){
            inOrder(root.left, k);
        }

        inOrderCounter++;
        if(k == inOrderCounter) {
            value = root.val;
            return;
        }

        if(Objects.nonNull(root.right)){
            inOrder(root.right, k);
        }
    }
}
