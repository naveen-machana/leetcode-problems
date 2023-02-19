package com.naveen.problems.strings;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/palindrome-partitioning-ii/description/
// Given a string s, partition s such that every substring of the partition is a palindrome
// Return the minimum cuts needed for a palindrome partitioning of s.
// This can be solved by two points:
//
// 1. cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
// 2. If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
// The 2nd point reminds us of using dp (caching).
// a   b   a   |   c  c
//                 j  i
//       j-1   |  [j, i] is palindrome
//    cut(j-1) +  1

public class Problem132_PalindromePartitioning2 {
    public int minCut(String s) {
        Map<String, Integer> mem = new HashMap<>();
        return minCuts(s, s.length(), mem);
    }

    private int minCuts(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] pal = new boolean[n][n];
        int[] mincuts = new int[n];

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (chars[i] == chars[j] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, mincuts[j - 1] + 1);
                }
            }
            mincuts[i] = min;
        }
        return mincuts[n - 1];
    }

    private int minCuts(String s, int end, Map<String, Integer> mem) {
        if (s.length() <= 1) return 0;
        if (mem.containsKey(s)) return mem.get(s);
        if (isPalindrome(s, 0, end - 1)) {
            mem.put(s, 0);
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int st = 1; st <= end; st++ ) {
            if (isPalindrome(s, 0, st - 1)) {
                String temp = s.substring(st);
                res = Math.min(res, 1 + minCuts(temp, temp.length(), mem));
            }
        }
        mem.put(s, res);
        return res;
    }

    private boolean isPalindrome(String s, int st, int end) {
        while (st < end) {
            if (s.charAt(st++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
