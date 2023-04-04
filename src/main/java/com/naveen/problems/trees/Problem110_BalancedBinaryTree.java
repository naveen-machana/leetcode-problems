package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/balanced-binary-tree/
* Given a binary tree, determine if it is height-balanced.
* */
public class Problem110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        Result result = new Result();
        isBalanced(root, result);
        return result.isHeightBalanced;
    }
    private int isBalanced(TreeNode root, Result result) {
        if (root == null) return 0;
        int left = isBalanced(root.left, result);
        int right = isBalanced(root.right, result);
        result.isHeightBalanced &= Math.abs(left - right) < 2;
        return Math.max(left, right) + 1;
    }
    private static class Result {
        boolean isHeightBalanced = true;
    }
}
