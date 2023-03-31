package com.naveen.problems.strings;

import java.util.stream.IntStream;

/*
* https://leetcode.com/problems/longest-repeating-character-replacement/
* You are given a string s and an integer k. You can choose any character of the string and change it to any other
* uppercase English character. You can perform this operation at most k times.
* Return the length of the longest substring containing the same letter you can get after performing the above operations.
* Input: s = "ABAB", k = 2
* Output: 4
* Explanation: Replace the two 'A's with two 'B's or vice versa.
*
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
* */
public class Problem424_LongestRepeatingCharacterReplacement {
    // approach 1
    public int characterReplacement2(String s, int k) {
        char[] a = s.toCharArray();
        int l = 0, n = a.length, res = 0;
        int[] count = new int[26];
        for (int r = 0; r < n; r++) {
            count[a[r] - 'A']++;
            int mfreq = IntStream.of(count).max().getAsInt();
            while (r - l + 1 - mfreq > k) {
                count[a[l] - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
