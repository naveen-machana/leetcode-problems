package com.naveen.problems.arrays.problem3;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// 3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring
// without repeating characters.
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.lengthOfLongestSubstring("abcabcbb");
    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            max = Math.max(max, i - j + 1);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
