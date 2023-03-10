package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/diameter-of-binary-tree/
* Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
* This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
* */
public class Problem543_DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        Result result = new Result();
        diameter(root, result);
        return result.max;
    }
    private int diameter(TreeNode root, Result result) {
        if (root == null) return 0;
        int left = diameter(root.left, result);
        int right = diameter(root.right, result);
        result.max = Math.max(result.max, left + right);
        return 1 + Math.max(left, right);
    }
    private static class Result {
        int max = 0;
    }
}
