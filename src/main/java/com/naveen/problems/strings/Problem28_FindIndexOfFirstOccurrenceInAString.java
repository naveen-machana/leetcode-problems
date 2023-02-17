package com.naveen.problems.strings;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1
// if needle is not part of haystack
// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
// proper prefix: a prefix of a string which is not the string itself. for eg: ab is a proper prefix of abc, abc is not.
// proper suffix: a suffix of a string which is not the string itself. for eg: bc is a proper suffix of abc, abc is not.
// border or lps, longest proper suffix is both proper prefix and proper suffix.
//
public class Problem28_FindIndexOfFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int hp = 0, np = 0, m = haystack.length(), n = needle.length();
        if (m < n) return -1;
        int[] lps = lps(needle);
        char[] hchars = haystack.toCharArray(), nchars = needle.toCharArray();

        while (hp < m) {
            if (hchars[hp] == nchars[np]) {
                hp++; np++;
                if (np == n) return hp - n;
            }
            else {
                if (np == 0) hp++;
                else {
                    np = lps[np - 1];
                }
            }
        }
        return -1;
    }

    int[] lps(String needle) {
        int n = needle.length();
        char[] chars = needle.toCharArray();
        int[] lps = new int[n];
        int j = 1, prev = 0;
        while (j < n) {
            if (chars[j] == chars[prev]) {
                prev++;
                lps[j++] = prev;
            }
            else {
                if (prev == 0) lps[j++] = 0;
                else {
                    prev = lps[prev - 1];
                }
            }
        }
        return lps;
    }
}
