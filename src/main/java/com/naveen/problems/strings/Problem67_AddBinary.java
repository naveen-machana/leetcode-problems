package com.naveen.problems.strings;

import java.util.Locale;

// https://leetcode.com/problems/add-binary/
// 67. Add Binary
// Given two binary strings a and b, return their sum as a binary string.
// Input: a = "11", b = "1"
// Output: "100"

// 1010 1011
// 0111
// 1111
// 10111
public class Problem67_AddBinary {
    public String addBinary(String a, String b) {
        char[] achars = a.toCharArray(), bchars = b.toCharArray();
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int sum = c;
            if (i >= 0) sum += achars[i--] - '0';
            if (j >= 0) sum += bchars[j--] - '0';
            res.append(sum % 2);
            c = sum / 2;
        }

        if (c > 0) res.append(c);
        return res.reverse().toString();
    }
}
