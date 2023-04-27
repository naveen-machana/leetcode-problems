package com.naveen.problems.strings;

/*
* https://leetcode.com/problems/merge-strings-alternately
* You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with
* word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
* Return the merged string.
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
* */
public class Problem1768_MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, m = word1.length(), n = word2.length();
        while (i < m || j < n) {
            if (i < m) sb.append(word1.charAt(i++));
            if (j < n) sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
