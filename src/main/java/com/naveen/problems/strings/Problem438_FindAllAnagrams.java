package com.naveen.problems.strings;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the
// answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.
// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
public class Problem438_FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();

        int[] pc = new int[26];
        for (char c : p.toCharArray()) pc[c - 'a']++;
        int[] sc = new int[26];
        int pn = p.length();
        for (int i = 0; i < pn - 1; i++) sc[s.charAt(i) - 'a']++;

        List<Integer> res = new ArrayList<>();
        for (int i = pn - 1; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            sc[c]++;

            boolean matched = true;
            for (int j = 0; j < 26; j++) {
                if (sc[j] != pc[j]) {
                    matched = false; break;
                }
            }
            if (matched) res.add(i - pn - 1);
            sc[s.charAt(i - pn + 1) - 'a']--;
        }
        return res;
    }
}
