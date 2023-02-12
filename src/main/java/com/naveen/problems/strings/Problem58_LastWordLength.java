package com.naveen.problems.strings;

// https://leetcode.com/problems/length-of-last-word/
// Given a string s consisting of words and spaces, return the length of the last word in the string.
//
// A word is a maximal substring consisting of non-space characters only.
// "Hello World"
// The last word is "World" with length 5.
public class Problem58_LastWordLength {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') length++;
            else {
                if (length > 0) return length;
            }
        }
        return length;
    }
}
