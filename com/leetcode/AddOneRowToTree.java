package com.leetcode;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        recurse(root, val, depth, 1);
        return root;
    }

    private void recurse(TreeNode node, int val, int depth, int runningDepth) {
        if (runningDepth == depth - 1) {
            TreeNode oldLeft = node.left;
            TreeNode oldRight = node.right;

            TreeNode newLeft = new TreeNode(val, oldLeft, null);
            TreeNode newRight = new TreeNode(val, null, oldRight);

            node.left = newLeft;
            node.right = newRight;
        } else {
            if (node.left != null) {
                recurse(node.left, val, depth, runningDepth + 1);
            }
            if (node.right != null) {
                recurse(node.right, val, depth, runningDepth + 1);
            }
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