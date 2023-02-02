package com.naveen.problems.graphs.problem1061;

// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
// 1061. Lexicographically Smallest Equivalent String
// You are given two strings of the same length s1 and s2 and a string baseStr.
//
// We say s1[i] and s2[i] are equivalent characters.
//
// For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
// Equivalent characters follow the usual rules of any equivalence relation:
//
// Reflexivity: 'a' == 'a'.
// Symmetry: 'a' == 'b' implies 'b' == 'a'.
// Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
// For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are
// equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.
//
// Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.
public class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] s1Str = s1.toCharArray();
        char[] s2Str = s2.toCharArray();

        int[] unions = new int[26];
        for (int i = 0; i < unions.length; i++) unions[i] = i;

        for (int i = 0; i < s1Str.length; i++) {
            makeUnion(s1Str[i] - 'a', s2Str[i] - 'a', unions);
        }

        StringBuilder res = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int cp = find(c - 'a', unions);
            res.append((char)(cp + 'a'));
        }
        return res.toString();
    }

    void makeUnion(int a, int b, int[] unions) {
        int repa = find(a, unions);
        int repb = find(b, unions);
        if (repa == repb) return;
        if (repa < repb) unions[repb] = repa;
        else unions[repa] = repb;
    }

    int find(int a, int[] unions) {
        if (unions[a] == a) return a;
        return unions[a] = find(unions[a], unions);
    }

}
