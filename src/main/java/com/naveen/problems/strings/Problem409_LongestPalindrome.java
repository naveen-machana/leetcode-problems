package com.naveen.problems.strings;

import java.util.HashSet;

// https://leetcode.com/problems/longest-palindrome/description/
// 409. Longest Palindrome
// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
// that can be built with those letters.
//
// Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
public class Problem409_LongestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count++;
            }
            else set.add(c);
        }

        if (!set.isEmpty()) return 2 * count + 1;
        return 2 * count;
    }
}
