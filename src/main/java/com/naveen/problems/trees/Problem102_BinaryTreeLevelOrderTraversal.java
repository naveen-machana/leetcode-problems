package com.naveen.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.com/problems/binary-tree-level-order-traversal/
* Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
* level by level).
* */
public class Problem102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> resLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                resLevel.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(resLevel);
        }
        return res;
    }
}
