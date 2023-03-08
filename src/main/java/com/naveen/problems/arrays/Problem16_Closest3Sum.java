package com.naveen.problems.arrays;

/*
https://leetcode.com/problems/3sum-closest/
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is
closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
* */

import java.util.Arrays;

public class Problem16_Closest3Sum {
    public static void main(String[] args) {
        Problem16_Closest3Sum sol = new Problem16_Closest3Sum();
        int[] a = {4,0,5,-5,3,3,0,-4,-5};
        sol.threeSumClosest(a, -2);
    }
    public int threeSumClosest(int[] a, int target) {
        Arrays.sort(a);
        int closest = a[0] + a[1] + a[2];
        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            int j = i + 1, k = a.length - 1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum == target) return sum;
                if (Math.abs(target - sum) < Math.abs(target - closest)) closest = sum;
                if (sum < target) j++;
                else k--;
            }
        }
        return closest;
    }
}
