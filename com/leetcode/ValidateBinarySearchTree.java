package com.leetcode;

import java.util.Objects;

public class ValidateBinarySearchTree {

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

    private class Triplet{
        private boolean isValid;
        private int maxVal;
        private int minVal;
    }

    public boolean isValidBST(TreeNode root) {
        Triplet triplet = process(root);
        return triplet.isValid;
    }

    private Triplet process(TreeNode root) {
        if(Objects.isNull(root)) {
            return null;
        }
        boolean isValidLeft = true;
        boolean isValidRight = true;
        int max = root.val;
        int min = root.val;
        if(Objects.nonNull(root.left)) {
            Triplet leftTriplet = process(root.left);
            isValidLeft = leftTriplet.isValid && leftTriplet.maxVal < root.val;
            min = leftTriplet.minVal;
        }
        if(Objects.nonNull(root.right)) {
            Triplet rightTriplet = process(root.right);
            isValidRight = rightTriplet.isValid && rightTriplet.minVal > root.val;
            max = rightTriplet.maxVal;
        }

        boolean isValidLocal = (Objects.isNull(root.left) || root.left.val < root.val) &&
                (Objects.isNull(root.right) || root.right.val > root.val);

        Triplet returnVal = new Triplet();
        returnVal.isValid = isValidLeft && isValidLocal && isValidRight;
        returnVal.minVal = min;
        returnVal.maxVal = max;
        return returnVal;
    }
}
