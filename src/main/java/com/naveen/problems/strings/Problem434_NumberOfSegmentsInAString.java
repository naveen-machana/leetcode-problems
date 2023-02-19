package com.naveen.problems.strings;

// https://leetcode.com/problems/number-of-segments-in-a-string/
// Given a string s, return the number of segments in the string.
//
// A segment is defined to be a contiguous sequence of non-space characters.
//
// Example 1:
//
// Input: s = "Hello, my name is John"
// Output: 5
// Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
public class Problem434_NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ')
                count++;
        return count;
    }
}
