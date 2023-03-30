package com.naveen.problems.binarysearch;

/*
* https://leetcode.com/problems/sum-of-square-numbers/
* Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
* Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
* */
public class Problem633_SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        long l = 0, r = (long)Math.sqrt(c);
        while (l <= r) {
            long x = l * l + r * r;
            if (x == c) return true;
            else if (x > c) r--;
            else l++;
        }
        return false;
    }
}
