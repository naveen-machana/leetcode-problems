package com.naveen.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.com/problems/binary-tree-right-side-view/
* Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
* you can see ordered from top to bottom.
* */
public class Problem199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode rightMostNode = null;
        while (!q.isEmpty()) {
            rightMostNode = null;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur != null) {
                    rightMostNode = cur;
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            if (rightMostNode != null) res.add(rightMostNode.val);
        }
        return res;
    }
}
