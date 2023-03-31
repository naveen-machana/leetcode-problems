package com.naveen.problems.strings;

/*
* https://leetcode.com/problems/permutation-in-string/
* Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
* In other words, return true if one of s1's permutations is the substring of s2.
* Input: s1 = "ab", s2 = "eidbaooo"
* Output: true
* Explanation: s2 contains one permutation of s1 ("ba").
* */
public class Problem567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (char c : c1) cnt1[c - 'a']++;
        for (int i = 0; i < c1.length; i++) cnt2[c2[i] - 'a']++;
        int matched = 0;
        for (int i = 0; i < 26; i++)
            if (cnt1[i] == cnt2[i])
                matched++;
        for (int i = c1.length; i < c2.length; i++) {
            if (matched == 26) return true;
            cnt2[c2[i] - 'a']++;
            cnt2[c2[i - c1.length] - 'a']--;
            if (cnt1[c1[i] - 'a'] == cnt2[c2[i] - 'a']) matched++;
            else matched--;
        }
        return matched == 26;
    }
}
