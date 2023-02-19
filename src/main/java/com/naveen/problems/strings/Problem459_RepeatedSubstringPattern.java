package com.naveen.problems.strings;

// https://leetcode.com/problems/repeated-substring-pattern/description/
// Given a string s, check if it can be constructed by taking a substring of it and appending
// multiple copies of the substring together.
// Input: s = "abab"
// Output: true
// Explanation: It is the substring "ab" twice.
// aba
// abaaba => baab.contains(aba)
// abcabc => abcabcabcabc => bcabcabcab.contains("abcabc")
public class Problem459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String str = s.concat(s);
        return str.substring(1, str.length() - 1).contains(s);
    }
}
