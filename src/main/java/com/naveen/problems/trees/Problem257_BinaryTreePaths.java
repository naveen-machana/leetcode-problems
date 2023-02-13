package com.naveen.problems.trees;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/
// 257. Binary Tree Paths
// Given the root of a binary tree, return all root-to-leaf paths in any order.
//
// A leaf is a node with no children.
public class Problem257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        path(root, "", paths);
        return paths;
    }
    private void path(TreeNode root, String path, List<String> paths) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            path = path + root.val;
            paths.add(path);
            return;
        }
        path(root.left, path + root.val + "->", paths);
        path(root.right, path + root.val + "->", paths);
    }
}
