package com.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Solution to the leetcode problem 1382
 */
public class BalanceABinarySearchTree {
    private List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        recurse(root);
        return build(0, list.size() - 1);
    }

    private TreeNode build(int i, int j) {
        if(j < i) {
            return null;
        }
        if(i == j) {
            return new TreeNode(list.get(i));
        }
        if(i == j -1 ) {
            return new TreeNode(list.get(i), null, new TreeNode(list.get(j)));
        }
        // i and j are inclusive indices
        // 0-indexing
        int mid = (int)(i + j) / 2;
        return new TreeNode(list.get(mid), build(i, mid - 1), build(mid + 1, j) );
    }

    private void recurse(TreeNode node) {
        if(node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        if(node.left != null) {
            recurse(node.left);
        }
        list.add(node.val);
        if(node.right != null) {
            recurse(node.right);
        }
    }

    public static class TreeNode {
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

}


