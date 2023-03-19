package com.naveen.problems.problem2169.sorting;

import java.util.Arrays;

/*
* https://leetcode.com/problems/squares-of-a-sorted-array/description/
* Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
* sorted in non-decreasing order.
* Input: nums = [-4,-1,0,3,10]
* Output: [0,1,9,16,100]
* Explanation: After squaring, the array becomes [16,1,0,9,100].
* After sorting, it becomes [0,1,9,16,100].
* */
public class Problem977_SquaresOfASortedArray {
    public static void main(String[] args) {
        Problem977_SquaresOfASortedArray sol = new Problem977_SquaresOfASortedArray();
        int[] a = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sol.sortedSquares(a)));
    }
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int st = 0, end = nums.length - 1, p = nums.length - 1;
        while (st <= end) {
            int stsq = nums[st] * nums[st];
            int endsq = nums[end] * nums[end];
            if (stsq > endsq) {
                res[p--] = stsq;
                st++;
            }
            else {
                res[p--] = endsq;
                end--;
            }
        }
        return res;
    }
}
