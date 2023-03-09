package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/invert-binary-tree/
* Given the root of a binary tree, invert the tree, and return its root.
* */
public class Problem226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) return;
        invert(root.left);
        invert(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
