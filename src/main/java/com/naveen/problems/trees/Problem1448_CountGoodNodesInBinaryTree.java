package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/count-good-nodes-in-binary-tree/
* Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with
* a value greater than X. Return the number of good nodes in the binary tree.
* */
public class Problem1448_CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }
    private int countGoodNodes(TreeNode root, int val) {
        if (root == null) return 0;
        int c = root.val >= val ? 1 : 0;
        int data = root.val >= val ? root.val : val;
        return c + countGoodNodes(root.left, data) + countGoodNodes(root.right, data);
    }
}
