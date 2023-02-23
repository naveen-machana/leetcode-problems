package com.naveen.problems.binarysearch;

/*
https://leetcode.com/problems/sqrtx/
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
* */
public class Problem69_sqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1, r = x;
        while (true) {
            int m = l + (r - l)/2;
            if (m > x/m) r = m - 1;
            else {
                if (m + 1 > x / (m + 1)) return m;
                else l = m + 1;
            }
        }
    }
}
