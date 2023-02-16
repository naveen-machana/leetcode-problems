package com.naveen.problems.strings;

// https://leetcode.com/problems/reverse-string/
// 344. Reverse String
// Write a function that reverses a string. The input string is given as an array of characters s.
//
// You must do this by modifying the input array in-place with O(1) extra memory.
// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
public class Problem344_ReverseString {
    public void reverseString(char[] s) {
        int st = 0, end = s.length - 1;
        while (st < end) {
            char t = s[st];
            s[st] = s[end];
            s[end] = t;
            st++; end--;
        }
    }
}
