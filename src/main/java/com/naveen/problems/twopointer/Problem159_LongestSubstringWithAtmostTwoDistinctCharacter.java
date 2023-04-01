package com.naveen.problems.twopointer;

// 159. Longest Substring with At Most Two Distinct Characters
// https://leetcode.ca/all/159.html
// Input: "eceba"
// Output: 3
// Explanation: t is "ece" which its length is 3.
public class Problem159_LongestSubstringWithAtmostTwoDistinctCharacter {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int st = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;
        while (end < s.length()) {
            char c1 = s.charAt(end++);
            map[c1]++;
            if (map[c1] == 1) counter++;
            while (counter > 2) {
                char c2 = s.charAt(st++);
                if (map[c2] == 1) counter--;
                map[c2]--;
            }
            maxLen = Math.max(maxLen, end - st);
        }
        return maxLen;
    }
}
