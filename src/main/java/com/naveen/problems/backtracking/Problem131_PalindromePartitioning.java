package com.naveen.problems.strings;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
// Given a string s, partition s such that every substring of the partition is a palindrome
//. Return all possible palindrome partitioning of s.
public class Problem131_PalindromePartitioning {
    public static void main(String[] args) {
        Problem131_PalindromePartitioning sol = new Problem131_PalindromePartitioning();
        System.out.println(sol.partition("aabaa"));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        generate(s, s.length(), cur, res);
        return res;
    }

    void generate(String s, int st, List<String> cur, List<List<String>> res) {
        if (st >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int end = st; end < s.length(); end++) {
            if (isPalindrome(s, st, end)) {
                cur.add(s.substring(st, end + 1));
                generate(s, end + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isPalindrome(String a, int st, int end) {
        while (st < end) {
            if (a.charAt(st++) != a.charAt(end--))
                return false;
        }
        return true;
    }

    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        generate2(s, s.length(), cur, res, dp);
        return res;
    }

    void generate2(String s, int st, List<String> cur, List<List<String>> res, boolean[][] dp) {
        if (st >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int end = st; end < s.length(); end++) {
            if (s.charAt(st) == s.charAt(end) && (end - st <= 2 || dp[st + 1][end - 1])) {
                dp[st][end] = true;
                cur.add(s.substring(st, end + 1));
                generate2(s, end + 1, cur, res, dp);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
