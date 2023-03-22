package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/unique-binary-search-trees
* Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n
* nodes of unique values from 1 to n.
*
* */
public class Problem96_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                dp[i] += (dp[j] * dp[i - j - 1]);
        return dp[n];
    }
}
