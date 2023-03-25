package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/longest-palindromic-subsequence/
* */
public class Problem516_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq2(String s) {
        StringBuilder sb = new StringBuilder(s);
        Map<String, Integer> dp = new HashMap<>();
        char[] rev = sb.reverse().toString().toCharArray();
        return lcs(s.toCharArray(), rev, s.length(), s.length(), dp);
    }

    int lcs(char[] a, char[] b, int an, int bn, Map<String, Integer> dp) {
        if (an == 0 || bn == 0) return 0;
        String key = an + ":" + bn;
        if (dp.containsKey(key)) return dp.get(key);
        int res = -1;
        if (a[an - 1] == b[bn - 1]) {
            res = 1 + lcs(a, b, an - 1, bn - 1, dp);
        }
        else {
            res = Math.max(lcs(a, b, an - 1, bn, dp),
                    Math.max(lcs(a, b, an, bn - 1, dp),
                            lcs(a, b, an - 1, bn - 1, dp)));
        }
        dp.put(key, res);
        return dp.get(key);
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        char[] b = sb.reverse().toString().toCharArray();
        char[] a = s.toCharArray();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1] == b[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[n][n];
    }

}
