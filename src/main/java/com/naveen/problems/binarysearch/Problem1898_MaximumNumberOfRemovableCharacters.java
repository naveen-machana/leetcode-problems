package com.naveen.problems.binarysearch;

/*
* https://leetcode.com/problems/maximum-number-of-removable-characters/
* You are given two strings s and p where p is a subsequence of s. You are also given a distinct 0-indexed integer array
*  removable containing a subset of indices of s (s is also 0-indexed).
* You want to choose an integer k (0 <= k <= removable.length) such that, after removing k characters from s using the
* first k indices in removable, p is still a subsequence of s. More formally, you will mark the character at
* s[removable[i]] for each 0 <= i < k, then remove all marked characters and check if p is still a subsequence.
* Return the maximum k you can choose such that p is still a subsequence of s after the removals.
* A subsequence of a string is a new string generated from the original string with some characters (can be none)
* deleted without changing the relative order of the remaining characters.
* Input: s = "abcacb", p = "ab", removable = [3,1,0]
* Output: 2
* Explanation: After removing the characters at indices 3 and 1, "abcacb" becomes "accb".
* "ab" is a subsequence of "accb".
* If we remove the characters at indices 3, 1, and 0, "abcacb" becomes "ccb", and "ab" is no longer a subsequence.
* Hence, the maximum k is 2.
*
* Input: s = "abcbddddd", p = "abcd", removable = [3,2,1,4,5,6]
Output: 1
Explanation: After removing the character at index 3, "abcbddddd" becomes "abcddddd".
"abcd" is a subsequence of "abcddddd".
* */
public class Problem1898_MaximumNumberOfRemovableCharacters {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] schars = s.toCharArray();
        int l = 0, r = removable.length;
        while (l <= r) {
            int m = (l + r)/2;
            for (int i = 0; i < m; i++) schars[removable[i]] = '-';
            if (check(schars, p)) l = m + 1;
            else {
                r = m - 1;
                for (int i = 0; i < m; i++) schars[removable[i]] = s.charAt(removable[i]);
            }
        }
        return r;
    }

    private boolean check(char[] schars, String p) {
        int j = 0;
        for (int i = 0; i < schars.length && j < p.length(); i++)
            if (schars[i] != '-' && schars[i] == p.charAt(j)) j++;
        return j == p.length();
    }
}
