package com.naveen.problems.strings;

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
        System.out.println(sol.numDecodings("226"));
    }
    public int numDecodings(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        return count(s, 0, map);
    }

    int count(String s, int p, Map<Integer, Integer> map) {
        int n = s.length();
        if (p == n) return 1;
        if (map.containsKey(p)) return map.get(p);
        if (s.charAt(p) == '0') return 0;
        int res = count(s, p + 1, map);
        if (p + 1 < n && (s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p + 1) < '7'))
            res += count(s, p + 2, map);
        map.put(p, res);
        return res;
    }

    int count2(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                if (i + 1 < n && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
