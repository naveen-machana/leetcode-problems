package com.naveen.problems.twopointer;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/minimum-window-substring/description/
* Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
* character in t (including duplicates) is included in the window. If there is no such substring,
* return the empty string "". The testcases will be generated such that the answer is unique.
* Input: s = "ADOBECODEBANC", t = "ABC"
* Output: "BANC"
* Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
* */
public class Problem76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int st = 0, end = 0, minLen = Integer.MAX_VALUE, minStart = 0, counter = t.length();
        while (end < s.length()) {
            char c1 = s.charAt(end++);
            if (map[c1] > 0) counter--;
            map[c1]--;
            while (counter == 0) {
                if (minLen > end - st) {
                    minLen = end - st;
                    minStart = st;
                }
                char c2 = s.charAt(st++);
                map[c2]++;
                if (map[c2] > 0) counter++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
