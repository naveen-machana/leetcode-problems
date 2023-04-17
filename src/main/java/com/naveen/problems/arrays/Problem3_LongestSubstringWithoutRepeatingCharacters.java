package com.naveen.problems.arrays;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// 3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring
// without repeating characters.
// try for : abcbad
public class Problem3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Problem3_LongestSubstringWithoutRepeatingCharacters s = new Problem3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) i = Math.max(i, map.get(c) + 1);
            map.put(c, j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
