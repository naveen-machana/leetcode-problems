package com.naveen.problems.arrays;

/*
* https://leetcode.com/problems/single-number/
* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
*
Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
* */
public class Problem136_SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) xor ^= n;
        return xor;
    }
}
