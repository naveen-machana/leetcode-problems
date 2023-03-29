package com.naveen.problems.binarysearch;

/*
* https://leetcode.com/problems/find-smallest-letter-greater-than-target
* You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
* There are at least two different characters in letters.
* Return the smallest character in letters that is lexicographically greater than target.
* If such a character does not exist, return the first character in letters.

Example 1:
Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
*
Example 2:
Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
*
Example 3:
Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
* */
public class Problem744_Ceil {
    public char nextGreatestLetter(char[] a, char target) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r)/2;
            if (a[m] > target) r = m;
            else l = m + 1;
        }
        return l == a.length ? a[0] : a[l];
    }
}
