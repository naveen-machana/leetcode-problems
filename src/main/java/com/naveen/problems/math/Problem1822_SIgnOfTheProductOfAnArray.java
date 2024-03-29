package com.naveen.problems.math;

/*
* https://leetcode.com/problems/sign-of-the-product-of-an-array/
* There is a function signFunc(x) that returns:
1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.

Return signFunc(product).
*
* Input: nums = [-1,-2,-3,-4,3,2,1]
Output: 1
Explanation: The product of all values in the array is 144, and signFunc(144) = 1
*
* Input: nums = [1,5,0,2,-3]
Output: 0
Explanation: The product of all values in the array is 0, and signFunc(0) = 0
* */
public class Problem1822_SIgnOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int x : nums)
            if (x < 0) sign = -sign;
            else if (x == 0) return 0;

        return sign;
    }
}
