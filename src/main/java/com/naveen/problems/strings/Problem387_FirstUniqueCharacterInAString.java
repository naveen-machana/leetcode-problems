package com.naveen.problems.strings;

// https://leetcode.com/problems/first-unique-character-in-a-string/
// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
// Input: s = "loveleetcode"
// Output: 2
public class Problem387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 0) count[index] = (i + 1);
            else if (count[index] > 0) count[index] = -count[index];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] > 0) min = Math.min(min, count[index]);
        }
        return min != Integer.MAX_VALUE ? min - 1 : -1;
    }
}
