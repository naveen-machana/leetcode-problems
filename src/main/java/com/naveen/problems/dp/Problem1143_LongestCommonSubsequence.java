package com.naveen.problems.dp;

/*
* https://leetcode.com/problems/longest-common-subsequence
* Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common
* subsequence, return 0. A subsequence of a string is a new string generated from the original string with some
* characters (can be none) deleted without changing the relative order of the remaining characters.
* For example, "ace" is a subsequence of "abcde".
* A common subsequence of two strings is a subsequence that is common to both strings.
*
* Input: text1 = "abcde", text2 = "ace"
* Output: 3
* Explanation: The longest common subsequence is "ace" and its length is 3.
* */
public class Problem1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[m][n];
    }
}
