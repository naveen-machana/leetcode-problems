package com.naveen.problems.strings;

/*
* https://leetcode.com/problems/to-lower-case
* Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
* Example 1:
* Input: s = "Hello"
* Output: "hello"
* */
public class Problem709_ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            if (c >= 'A' && c <= 'Z') sb.append((char)('a' + (c - 'A')));
            else sb.append(c);
        return sb.toString();
    }
}
