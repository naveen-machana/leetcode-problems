package com.naveen.problems.strings;

// https://leetcode.com/problems/add-strings/
// Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
//
// You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
// You must also not convert the inputs to integers directly.
public class Problem415_AddStrings {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();
        int i = m - 1, j = n - 1, c = 0;
        while (i >= 0 || j >= 0) {
            int sum = c;
            if (i >= 0) sum += (num1.charAt(i--) - '0');
            if (j >= 0) sum += (num2.charAt(j--) - '0');
            sb.append(sum % 10);
            c = sum / 10;
        }
        if (c > 0) sb.append(c);
        return sb.reverse().toString();
    }
}
