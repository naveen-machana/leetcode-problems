package com.naveen.blind75.arrays;

public class Problem242_ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            counts[c - 'a'] -= 1;
            if (counts[c - 'a'] < 0) {
                return false;
            }
        }
        for (int n : counts) {
            if (n != 0) return false;
        }
        return true;
    }
}
