package com.naveen.problems.dp;

// https://leetcode.com/problems/longest-palindromic-substring/
// 5. Longest Palindromic Substring
// Given a string s, return the longest palindromic substring in s.
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
public class Problem5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] m = new int[n][n];
        int[] pos = {0, 0};
        int max = 1;

        for (int i = 0; i < n; i++) m[i][i] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                m[i][i + 1] = 2;
                pos[0] = i; pos[1] = i + 1; max = 2;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (m[j + 1][j + i - 1] != 0 && s.charAt(j) == s.charAt(j + i)) {
                    m[j][j + i] = m[j + 1][j + i - 1] + 2;
                    if (max < m[j][j + i]) {
                        max = m[j][j + i];
                        pos[0] = j; pos[1] = j + i;
                    }
                }
            }
        }

        return s.substring(pos[0], pos[1] + 1);
    }
}
