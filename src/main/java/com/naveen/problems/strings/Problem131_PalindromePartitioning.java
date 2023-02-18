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

    void generate(String s, int n, List<String> cur, List<List<String>> res) {
        if (n == 0) {
            List<String> temp = new ArrayList<>();
            for (int i = cur.size() - 1; i >= 0; i--)
                temp.add(cur.get(i));
            res.add(temp);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            String temp = s.substring(0, i);
            String rest = s.substring(i);
            if (isPalindrome(rest)) {
                cur.add(rest);
                generate(temp, temp.length(), cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isPalindrome(String a) {
        if (a.length() == 0) return false;
        return a.equals(new StringBuilder(a).reverse().toString());
    }
}
