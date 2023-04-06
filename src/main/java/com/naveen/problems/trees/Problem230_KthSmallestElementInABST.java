package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/kth-smallest-element-in-a-bst/
* Given the root of a binary search tree, and an integer k, return the kth smallest value
* (1-indexed) of all the values of the nodes in the tree.
* */
public class Problem230_KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Result res = new Result();
        kthSmallest(root, k, res);
        return res.kthSmallest;
    }

    private void kthSmallest(TreeNode root, int k, Result res) {
        if (root == null) return;
        kthSmallest(root.left, k, res);
        if (++res.count == k) res.kthSmallest = root.val;
        kthSmallest(root.right, k, res);
    }

    private static class Result {
        int kthSmallest;
        int count;
    }
}
