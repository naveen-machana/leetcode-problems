package com.naveen.problems.strings;

// https://leetcode.com/problems/valid-anagram/
// 242. Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.

public class Problem242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) count[t.charAt(i) - 'a']--;
        for (int i = 0; i < 26; i++)
            if (count[i] != 0)
                return false;

        return true;
    }
}
