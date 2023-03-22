package com.naveen.problems.dp;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/decode-ways/
// A message containing letters from A-Z can be encoded into numbers using the following mapping:
//
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
// To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of
// the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
//
// "AAJF" with the grouping (1 1 10 6)
// "KJF" with the grouping (11 10 6)
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
//
// Given a string s containing only digits, return the number of ways to decode it.
//
// The test cases are generated so that the answer fits in a 32-bit integer.
// Input: s = "226"
// Output: 3
// Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
public class Problem91_DecodeWays {
    public static void main(String[] args) {
        Problem91_DecodeWays sol = new Problem91_DecodeWays();
        //System.out.println(sol.numDecodings("17"));
        String s = "17";
        int[] dp = new int[s.length()];
        System.out.println(sol.count(s.toCharArray(), 0, s.length(), dp));
    }

    public int numDecodings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = (chars[i] == '0') ? 0 : dp[i + 1];
            dp[i] += (i + 1 < n && (chars[i] == '1' || chars[i] == '2' && chars[i + 1] <= '6')) ? dp[i + 2] : 0;
        }
        return dp[0];
    }

    int count(char[] c, int i, int n, int[] dp) {
        if (i >= n) return 1;
        if (dp[i] != 0) return dp[i];
        if (c[i] == '0') return 0;
        int ways = count(c, i + 1, n, dp);
        if (i + 1 < n && (c[i] == '1' || c[i] == '2' && c[i + 1] <= '6'))
            ways += count(c, i + 2, n, dp);
        dp[i] = ways;
        return dp[i];
    }
}
