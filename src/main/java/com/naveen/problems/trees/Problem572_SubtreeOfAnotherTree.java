package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/subtree-of-another-tree/
* Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
* structure and node values of subRoot and false otherwise. A subtree of a binary tree tree is a tree that consists of
* a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
* */
public class Problem572_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
