package com.naveen.problems.trees;

/*
* https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
* Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced
 binary search tree.
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:
* */
public class Problem108_ConvertSortedArrayToHeightBalancedBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }

    private TreeNode convert(int[] a, int st, int end) {
        if (st > end) return null;
        TreeNode node = new TreeNode();
        int m = (st + end)/2;
        node.val = a[m];
        if (st == end) return node;
        node.left = convert(a, st, m - 1);
        node.right = convert(a, m + 1, end);
        return node;
    }
}
