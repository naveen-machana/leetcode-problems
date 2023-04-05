package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/validate-binary-search-tree/
* Given the root of a binary tree, determine if it is a valid binary search tree (BST).
* A valid BST is defined as follows:
* The left subtree of a node contains only nodes with keys less than the node's key.
* The right subtree of a node contains only nodes with keys greater than the node's key.
* Both the left and right subtrees must also be binary search trees.
* */
public class Problem98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if ((root != null && root.val <= min.val) || (root != null && root.val >= max.val)) return false;
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
}
