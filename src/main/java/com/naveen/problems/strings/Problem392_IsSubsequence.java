package com.naveen.problems.strings;

// https://leetcode.com/problems/is-subsequence/description/
// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//
//A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of
// the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence
// of "abcde" while "aec" is not).
public class Problem392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0, m = s.length(), n = t.length();
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == m;
    }
}
