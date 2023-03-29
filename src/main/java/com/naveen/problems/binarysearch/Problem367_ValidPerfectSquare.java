package com.naveen.problems.binarysearch;

/*
* https://leetcode.com/problems/valid-perfect-square
* Given a positive integer num, return true if num is a perfect square or false otherwise.
* A perfect square is an integer that is the square of an integer.
* In other words, it is the product of some integer with itself.
* You must not use any built-in library function, such as sqrt.
* Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
* */
public class Problem367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long l = 1, h = num;
        while (l <= h) {
            long m = (l + h)/2;
            if (m * m == num) return true;
            else if (m * m > num) h = m - 1;
            else l = m + 1;
        }
        return false;
    }
}
