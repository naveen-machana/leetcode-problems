package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/symmetric-tree/
* Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
* */
public class Problem101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }

        return left.val == right.val && isSymmetric(left.right, right.left)
                && isSymmetric(left.left, right.right);
    }
}
