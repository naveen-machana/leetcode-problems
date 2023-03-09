package com.naveen.problems.trees;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/binary-tree-inorder-traversal/
* Given the root of a binary tree, return the inorder traversal of its nodes' values.
*
* */
public class Problem94_InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
