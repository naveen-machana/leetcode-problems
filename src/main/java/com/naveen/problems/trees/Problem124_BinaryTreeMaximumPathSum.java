package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/binary-tree-maximum-path-sum/
* A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an
* edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass
* through the root. The path sum of a path is the sum of the node's values in the path.
* Given the root of a binary tree, return the maximum path sum of any non-empty path.
* */
public class Problem124_BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        Result result = new Result();
        result.max = root.val;
        maxPathSum(root, result);
        return result.max;
    }

    private int maxPathSum(TreeNode root, Result result) {
        if (root == null) return 0;
        int left = maxPathSum(root.left, result);
        int right = maxPathSum(root.right, result);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        result.max = Math.max(result.max, root.val + left + right);
        return root.val + Math.max(left, right);
    }

    private static class Result { int max; }
}
