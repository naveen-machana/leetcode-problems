package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
* Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
* According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
* the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
* */
public class Problem235_LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val && cur.val > q.val) cur = cur.left;
            else if (cur.val < p.val && cur.val < q.val) cur = cur.right;
            else return cur;
        }
        return null;
    }
}
