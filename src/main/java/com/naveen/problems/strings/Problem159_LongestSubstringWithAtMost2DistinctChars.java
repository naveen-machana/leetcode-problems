package com.naveen.problems.strings;

import java.util.HashSet;
import java.util.Set;

// 159. Longest Substring with At Most Two Distinct Characters
// https://leetcode.ca/all/159.html
// Input: "eceba"
// Output: 3
// Explanation: t is "ece" which its length is 3.
public class Problem159_LongestSubstringWithAtMost2DistinctChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int k = 2;
        int[] count = new int[26];
        int max = Integer.MIN_VALUE;
        Set<Character> seen = new HashSet<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            count[c - 'a']++;
            seen.add(c);

            while (seen.size() > k) {
                if (--count[s.charAt(i) - 'a'] == 0) {
                    seen.remove(s.charAt(i));
                }
                i++;
            }

            max = Math.max(j - i + 1, max);
        }
        return max;
    }
}
