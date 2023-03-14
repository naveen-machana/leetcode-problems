package com.naveen.problems.graphs;

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
public class Problem1061_LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] s1chars = s1.toCharArray();
        char[] s2chars = s2.toCharArray();

        int[] unions = new int[26];
        for (int i = 0; i < 26; i++) unions[i] = i;
        for (int i = 0; i < s1chars.length; i++) makeUnion(s1chars[i] - 'a', s2chars[i] - 'a', unions);
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) sb.append((char)(find(c - 'a', unions) + 'a'));
        return sb.toString();
    }

    void makeUnion(int a, int b, int[] unions) {
        int repa = find(a, unions);
        int repb = find(b, unions);
        if (repa == repb) return;
        if (repa < repb) unions[repb] = repa;
        else unions[repa] = repb;
    }

    int find(int a, int[] unions) {
        if (a == unions[a]) return a;
        return unions[a] = find(unions[a], unions);
    }

}
